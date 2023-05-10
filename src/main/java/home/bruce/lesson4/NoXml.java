package home.bruce.lesson4;

import home.bruce.bean.Dog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;


@Component
@ComponentScan({"home.bruce.lesson3", "home.bruce.lesson4"})
@PropertySource("classpath:ioc/xxx.properties")
@Import(Dog.class) // 和 @Bean 差不多，但不能給屬性賦值
public class NoXml {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(NoXml.class);
        Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
