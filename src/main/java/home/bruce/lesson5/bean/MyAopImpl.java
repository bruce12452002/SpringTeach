package home.bruce.lesson5.bean;

import org.springframework.stereotype.Component;

@Component
public class MyAopImpl implements MyAop {
    @Override
    public void before() {
        System.out.println("MyAopImpl-before");
    }

    @Override
    public void after() {
        System.out.println("MyAopImpl-after");
    }
}
