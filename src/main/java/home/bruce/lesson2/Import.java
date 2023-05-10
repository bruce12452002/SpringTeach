package home.bruce.lesson2;

import home.bruce.bean.Pig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Import {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc/import.xml", "ioc/constructor.xml");
//        ApplicationContext context = new ClassPathXmlApplicationContext("import.xml");
        context.getBean("p1", Pig.class);
    }
}
