package home.bruce.lesson8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class TestTxDBWithMix {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcTemplateConfig.class);
        ApplicationContext context = new ClassPathXmlApplicationContext("tx/txMix.xml");
        // Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);
        TestTxDBWithMix testTxDBWithMix = context.getBean(TestTxDBWithMix.class);
        testTxDBWithMix.update(1000);
    }

    public void update(int transferMoney) {
        Integer id1 = jdbcTemplate.queryForObject("select money from user_account where id = 1", Integer.class);
        Integer id2 = jdbcTemplate.queryForObject("select money from user_account where id = 2", Integer.class);
        jdbcTemplate.update("update user_account set money = " + (id1 - transferMoney) + " where id = 1");

        int i = 1 / 0;
        jdbcTemplate.update("update user_account set money = " + (id2 + transferMoney) + " where id = 2");
    }
}
