package home.bruce.lesson2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * init-method="start"
 * 初始化方法一定是無參的，但可有回傳值
 * <p>
 * <p>
 * destroy-method="end"
 * 銷毀方法可無參或一個 boolean 參數，但可有回傳值
 * 如果有參數，永遠為 true
 * 可看源碼是寫死的 DisposableBeanAdapter.invokeCustomDestroyMethod
 * <p>
 * 回傳值都沒有拿來用，但如果自己的專案，其他地方有調用到，可以一次拿來做這兩件事，但不建議
 */
public class InitAndDestroy {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ioc/initAndDestroy.xml");
        context.close(); // scope="singleton" 且有關閉才會調用 destroy-method 的方法，但 ApplicationContext 沒有關閉方法
    }
}
