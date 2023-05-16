package home.bruce.lesson7;

import home.bruce.lesson7.config.JdbcTemplateConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Component
public class TestTxDBWithManual {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSourceTransactionManager transactionManager;

    @Autowired
    private DefaultTransactionDefinition transactionDefinition;

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcTemplateConfig.class);
        // Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);
        TestTxDBWithManual testTxDB = context.getBean(TestTxDBWithManual.class);
        testTxDB.update(1000);
    }

    private void update(int transferMoney) {
        TransactionStatus status = transactionManager.getTransaction(transactionDefinition);
        try {
            Integer id1 = jdbcTemplate.queryForObject("select money from user_account where id = 1", Integer.class);
            Integer id2 = jdbcTemplate.queryForObject("select money from user_account where id = 2", Integer.class);
            jdbcTemplate.update("update user_account set money = " + (id1 - transferMoney) + " where id = 1");

            // int i = 1 / 0;
            jdbcTemplate.update("update user_account set money = " + (id2 + transferMoney) + " where id = 2");
        } catch (DataAccessException e) {
            transactionManager.rollback(status);
            e.printStackTrace();
        }
        transactionManager.commit(status);
    }
}
