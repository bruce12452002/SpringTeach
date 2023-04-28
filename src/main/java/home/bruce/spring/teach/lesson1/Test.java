package home.bruce.spring.teach.lesson1;


import home.bruce.spring.teach.lesson1.service.impl.Monkey;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
//        method1();
        method2();
    }

    private static void method1() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("beans.xml");

        Monkey m = (Monkey) beanFactory.getBean("m"); // 此時才會創建 Monkey
        System.out.println(m.getName());
    }

    /**
     * BeanFactory 和 ApplicationContext 區別
     * ApplicationContext 在 BeanFactory 的基礎上，進行擴展，監聽、事件、國際化…等
     * BeanFactory 首次調用才加載； ApplicationContext 在容器一啟動時就初始化好了
     */
    private static void method2() {
        // 雖然用 BeanFactory 來接，但 new ClassPathXmlApplicationContext 完就會創建 Monkey 了
//        BeanFactory context = new ClassPathXmlApplicationContext("beans.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        // ApplicationContext 是介面，實作的是 method1() 的 DefaultListableBeanFactory，
        // 可 debug 看 context 裡的 beanFactory 屬性
        // DefaultListableBeanFactory 裡的屬性 beanDefinitionMap 是放 xml 設定的地方，key 為類別名稱
        // new AnnotationConfigApplicationContext()，加載的是 class
        // 加載 spring web 時，還會在 hierarchy 看到多一些東西來繼承 ApplicationContext

        Monkey m = context.getBean("m", Monkey.class);
        System.out.println(m.getName());
    }
}
