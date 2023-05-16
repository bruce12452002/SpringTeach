package home.bruce;

import home.bruce.lesson10.Chair;
import home.bruce.lesson10.Desk;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Chair.class)
public class Junit5Test {
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

