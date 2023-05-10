package home.bruce.lesson5.service;

import org.springframework.stereotype.Service;

/**
 * JoinPoint (連接點)：某個 package 的 class
 * PointCut (切點)：class 裡的方法有多個，如果只對某幾個方法使用 aop，這幾個方法為切點，其他的不是
 * Advice (通知)：增加的程式碼，分前通知和後通知，前+後通知=環繞通知
 * Aspect (切面)：切點 + 通知
 * Weaving (織入)：切面的過程
 */
@Service
public class MyServiceImpl implements MyService {
    @Override
    public void display() {
        System.out.println("MyServiceImpl-display");
    }

    @Override
    public void display2(String s) {
        System.out.println("MyServiceImpl-display2");
    }
}
