package home.bruce.lesson2;

import home.bruce.bean.Dog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GetBean {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("getBean.xml");

        Dog d1 = (Dog) context.getBean("d");
        Dog d2 = context.getBean("d", Dog.class);
        Dog d3 = context.getBean(Dog.class); // 如果有兩個(含)以上的 Dog 又沒處理就會報錯

        // 以下使用 args 時，只能配合用 prototype 才有效果
        // 使用建構子
        Dog d4 = (Dog) context.getBean("d2", "dog1", 18);
        Dog d5 = context.getBean(Dog.class, "dog2", 20); // 如果有兩個(含)以上的 Dog 又沒處理就會報錯

        // 使用靜態工廠
        Dog d6 = (Dog) context.getBean("d3", "dog3", 22);
        // 使用實體工廠
        Dog d7 = (Dog) context.getBean("d4", "dog4", 24);

        System.out.println(d1.getTitle() + "=" + d1.getAge());
        System.out.println(d4.getTitle() + "=" + d4.getAge());
        System.out.println(d5.getTitle() + "=" + d5.getAge());
        System.out.println(d6.getTitle() + "=" + d6.getAge());
        System.out.println(d7.getTitle() + "=" + d7.getAge());
    }
}
