package home.bruce.spring.teach;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

//@ContextConfiguration(locations = { "classpath*:/beans.xml" })
@RunWith(SpringRunner.class)
class SpringTeachApplicationTests {
    @Test
    public void contextLoads() {
        System.out.println("xxxx");
    }

}
