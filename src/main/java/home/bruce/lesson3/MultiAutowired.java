package home.bruce.lesson3;

import home.bruce.lesson3.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MultiAutowired {
    /**
     * @Autowired 會先以型態匹配，但實作 XxxService 有兩個，這時還會以名稱匹配，如果名稱都不匹配會報錯
     * 如果名稱不改又想匹配成功，就要使用 @Qualifier 來指定名稱
     * 也可使用 @Primary，只要將這個 annotation 放在要被注入的類別上即可
     */
    @Autowired
    private XxxService xxxServiceImpl;

//    @Autowired
//    @Qualifier("xxxServiceImpl2")
//    private XxxService xxxServiceImpl3; // 沒有 xxxServiceImpl3 這個名稱在 spring 容器

    /**
     * @Resource 會先以屬性 name 匹配，沒匹配到就以名稱匹配，再沒有就以 type 屬性的型態匹配
     */
//    @Resource(type = XxxServiceImpl.class)
//    @Resource(name = "xxxServiceImpl")
//    private XxxService xxxServiceImpl3;

    /**
     * 不是自己寫的類別，無法增加 @Component，這時可用 @Bean
     */
    @Bean  // 方法的回傳值就是 class，@Bean 的 value 就是 id，不寫就是小寫開頭的方法名稱
    public Red getRed(@Value("${key}") int i, Yellow y) { // 參數裡的 Yellow 寫不寫 @Autowired 都可以，但有多個要加 @Qualifier
        System.out.println("key=" + i);
        System.out.println("y=" + y);
        return new Red();
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc/spring_scan.xml");
        MultiAutowired ma = context.getBean("multiAutowired", MultiAutowired.class);
        XxxServiceImpl xs1 = context.getBean("xxxServiceImpl", XxxServiceImpl.class);
        XxxServiceImpl2 xs2 = context.getBean("xxxServiceImpl2", XxxServiceImpl2.class);
        System.out.println(xs1);
        System.out.println(xs2);
        System.out.println(ma.xxxServiceImpl);
    }
}
