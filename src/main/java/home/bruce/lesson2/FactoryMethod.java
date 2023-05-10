package home.bruce.lesson2;

import home.bruce.bean.Dragon;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 在 bean 裡，如果只有寫 factory-method
 * factory-method 一定是 static，不能有參數
 * <p>
 * 在 bean 裡，如果有 factory-bean 和 factory-method
 * factory-bean 寫工廠類別
 * factory-method 不能是 static，不能有參數
 * <p>
 * 兩種類似靜態方法和非靜態方法，靜態方法可用類別去.；非靜態方法要用實體去.
 */
public class FactoryMethod {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ioc/factoryMethod.xml");
        // context.getBean("d1", FactoryMethod.class); // 取得的是 factory-method 設定的方法，裡面的回傳值
        context.getBean("d1", Dragon.class);
        context.getBean("d2", Dragon.class);

        context.getBean("d3", Dragon.class); // 方法的回傳值才是放在容器的物件
        context.getBean("d4", Dragon.class);

        context.getBean("d5", Dragon.class);
        context.close();
    }
}
