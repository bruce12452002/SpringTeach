package home.bruce;

import home.bruce.lesson10.Chair;
import home.bruce.lesson10.Desk;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Chair.class)
public class Junit4Test {
    @Autowired(required = false)
    private Chair chair;

    @Autowired(required = false)
    private Desk desk;

    @Test
    public void xxx() {
        System.out.println(chair);
        System.out.println(desk);
    }
}

