package home.bruce.lesson3;

import home.bruce.lesson3.bean.Yellow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class ClassPath {
    @Value("${key}")
    private int id;

//    @Value("${key2}")
    private String name;


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc/class_path.xml");
        ClassPath cp = context.getBean("classPath", ClassPath.class);
        System.out.println(cp.id + "=" + cp.name);
    }
}
