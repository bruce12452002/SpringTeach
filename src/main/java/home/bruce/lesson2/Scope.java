package home.bruce.lesson2;


import home.bruce.lesson1.service.impl.Monkey;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * scope 預設是 singleton，還有另一個選項是 prototype
 * 如果是 webmvc 還有 request 和 session
 */
public class Scope {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc/scope.xml");
        Monkey m1 = context.getBean("m", Monkey.class);
        Monkey m2 = context.getBean("m", Monkey.class);
        System.out.println(m1 == m2);
    }
}
