package home.bruce.bean;

import home.bruce.bean.Dragon;
import org.springframework.beans.factory.FactoryBean;

// 會存到 beanFactory -> factoryBeanObjectCache，並不是 singletonObjects，這個也是需要用到才會去加載
public class FactoryMethod2 implements FactoryBean<Dragon> {

    @Override
    public Dragon getObject() throws Exception {
        System.out.println("getObject()");
        return new Dragon();
    }

    @Override
    public Class<?> getObjectType() {
        return Dragon.class;
    }
}
