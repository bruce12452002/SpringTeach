package home.bruce.lesson8;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestTxDBWithXml {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("tx/tx.xml");
        // Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);
        TestTxDBWithXml testTxDBWithXml = context.getBean("txDBWithXml", TestTxDBWithXml.class);
        testTxDBWithXml.setJdbcTemplate(context.getBean("jdbcTemplate", JdbcTemplate.class));
        testTxDBWithXml.update(1000);
    }

    public void update(int transferMoney) {
        Integer id1 = jdbcTemplate.queryForObject("select money from user_account where id = 1", Integer.class);
        Integer id2 = jdbcTemplate.queryForObject("select money from user_account where id = 2", Integer.class);
        jdbcTemplate.update("update user_account set money = " + (id1 - transferMoney) + " where id = 1");

//        int i = 1 / 0;
        jdbcTemplate.update("update user_account set money = " + (id2 + transferMoney) + " where id = 2");
    }
}
