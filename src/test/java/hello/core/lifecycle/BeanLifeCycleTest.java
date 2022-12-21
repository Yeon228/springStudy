package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest(){
        //기본 ApplicationContext는 close 기능 제공안함
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig{

        @Bean(initMethod = "init", destroyMethod = "close")//init,close 메서드 지정
        //메서드 이름 자유롭게 사용 가능, 스프링 빈이 스프링 코드에 의존안함
        //외부 라이브러리에도 초기화, 종료 메서드 지정 가능 (중요)
        //destroyMethod는 지정을 안해줘도 기본적으로 사용되는 종료 메서드의 이름을 추론해서 호출해줌
        //추론기능 사용 안하고 싶을 시 destroyMethod=""로 하면됨
        public NetworkClient networkClient(){
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("asdf");
            return networkClient;
        }
    }
}
