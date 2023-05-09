package home.bruce.lesson3;

import home.bruce.lesson3.bean.Yellow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
@Configuration
@Component // <bean>
/* 以下四個 annotation 裡面都有 @Component，功能和 @Component 一樣
    @Controller
    @Service
    @Repository
    @Configuration
*/

@Scope("singleton") // <bean scope>
@Lazy(false) // <bean lazy-init>
public class SpringScan {
    @Value("${key}")
    private int id;
    private String name;

    @Autowired
    private Yellow yellow;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Value("monkey")
    public void setName(String name) {
        this.name = name;
    }

    @PostConstruct
    public void start() {
        System.out.println("start 被調用");
    }

    @PreDestroy
    public void end() {
        System.out.println("end 被調用");
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring_scan.xml");
        for (String s : context.getBeanDefinitionNames()) {
            System.out.println(s);
        }

        SpringScan sa = context.getBean("springScan", SpringScan.class);
        System.out.println(sa.getId() + "=" + sa.getName());
        context.close();
    }
}
