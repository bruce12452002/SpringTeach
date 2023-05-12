package home.bruce.lesson7;

import home.bruce.lesson7.config.JdbcTemplateConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class TestDB {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcTemplateConfig.class);
        // Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);
        TestDB testDB = context.getBean(TestDB.class);
//        testDB.update();
        testDB.query();
    }


    private void query() {
        System.out.println(jdbcTemplate.queryForObject("select name from user_account where id = 1", String.class));
        System.out.println("==========");
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from user_account");
        maps.forEach(m -> {
            m.forEach((k, v) -> System.out.println(k + "=" + v));
            System.out.println();
        });
    }

    private void update() {
        jdbcTemplate.update("insert into user_account values (2, \"小英\", 10000)");
    }
}
