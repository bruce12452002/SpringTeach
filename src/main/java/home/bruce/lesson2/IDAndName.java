package home.bruce.lesson2;


import home.bruce.lesson1.service.impl.Monkey;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * beanFactory -> singletonObjects 和 aliasMap
 * debug 時，查看 ApplicationContext 裡的屬性 singletonObjects 為 id； aliasMap 為 name
 * <p>
 * xml 裡的 id 為唯一的；name 可以很多，多個用,隔開
 * 當不設定 id 和 name 時，id 為 package.ClassName#0； name 為 package.ClassName
 * 但有設定 id 或 name，就不會有 package.ClassName#0 和 package.ClassName
 * <p>
 * 不設定 id 且只設定一個 name 時，name 為 id，沒有 name 屬性
 * 不設定 id 且當設定多個 name 時，第一個為 id，其他都是 name
 */
public class IDAndName {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("idAndName.xml");
        Monkey m1 = context.getBean("home.bruce.lesson1.service.impl.Monkey#0", Monkey.class);
        Monkey m2 = context.getBean("home.bruce.lesson1.service.impl.Monkey", Monkey.class);
//        Monkey m3 = context.getBean("z", Monkey.class);
        System.out.println(m1 == m2);

//        context.getBean("ooo", Monkey.class);
    }
}
