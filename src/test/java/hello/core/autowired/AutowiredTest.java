package hello.core.autowired;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowiredTest {

    @Test
    void autowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
        ac.getBean(TestBean.class);
    }

    static class TestBean{

    }
}
