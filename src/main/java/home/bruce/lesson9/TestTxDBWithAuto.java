package home.bruce.lesson9;

import home.bruce.lesson9.config.JdbcTemplateConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TestTxDBWithAuto {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("tx/txAuto.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcTemplateConfig.class);
        TestTxDBWithAuto testTxDB = context.getBean(TestTxDBWithAuto.class);
        testTxDB.update(1000);
    }

    // @Transactional 可寫在 TYPE 和 METHOD
//    @Transactional(transactionManager = "txManager")
    // transactionManager 不設定，會找 tx:annotation-driven transaction-manager
    // 當有多個 transactionManager，也可在這設定 transactionManager
    @Transactional
    public void update(int transferMoney) {
        Integer id1 = jdbcTemplate.queryForObject("select money from user_account where id = 1", Integer.class);
        Integer id2 = jdbcTemplate.queryForObject("select money from user_account where id = 2", Integer.class);
        jdbcTemplate.update("update user_account set money = " + (id1 - transferMoney) + " where id = 1");

//        int i = 1 / 0;
        jdbcTemplate.update("update user_account set money = " + (id2 + transferMoney) + " where id = 2");
    }
}
