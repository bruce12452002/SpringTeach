package home.bruce.lesson1.dao;

import org.springframework.beans.factory.InitializingBean;

public class AnimalDao implements InitializingBean {
    public String start() {
        System.out.println("start 被調用");
        return "ooo";
    }

    public String end(boolean b) {
        System.out.println("end 被調用" + b);
        return "xxx";
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("AnimalDao.class 初始化完會調用");
    }
}
