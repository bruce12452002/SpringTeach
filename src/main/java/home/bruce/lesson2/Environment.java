package home.bruce.lesson2;

import home.bruce.bean.AutowirePractice;
import home.bruce.bean.Dragon;
import home.bruce.bean.Pig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Environment {
    public static void main(String[] args) {
        // java -Dspring.profiles.active=dev 也行
        System.setProperty("spring.profiles.active", "dev");
//        System.setProperty("spring.profiles.active", "test");

        ApplicationContext context = new ClassPathXmlApplicationContext("environment.xml");
        context.getBean("ap", AutowirePractice.class); // 所有環境都可以
        context.getBean("d", Dragon.class); // 只有 dev 環境可以
        context.getBean("p", Pig.class); // 只有 test 環境可以
    }
}
