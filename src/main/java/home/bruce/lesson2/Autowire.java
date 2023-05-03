package home.bruce.lesson2;

import home.bruce.bean.AutowirePractice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Autowire {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("autowire.xml");
//        ApplicationContext context = new ClassPathXmlApplicationContext("autowire2.xml");

        AutowirePractice ap = context.getBean("ap", AutowirePractice.class);
        System.out.println(ap.getBigPig());
    }
}
