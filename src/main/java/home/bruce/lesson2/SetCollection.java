package home.bruce.lesson2;

import home.bruce.bean.PropertyPractice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class SetCollection {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc/propertyPractice.xml");
        PropertyPractice pp = context.getBean("pp", PropertyPractice.class);
        System.out.println(pp.getStrOfList());
        System.out.println(pp.getAnimalOfList());
        System.out.println(pp.getStrOfSet());
        System.out.println(pp.getMap());
        System.out.println(pp.getAnimalOfMap());
        System.out.println(pp.getPs());
        System.out.println(Arrays.toString(pp.getArr()));
        System.out.println(Arrays.deepToString(pp.getStrArr()));
    }
}
