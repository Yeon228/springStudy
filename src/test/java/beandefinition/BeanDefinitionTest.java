package beandefinition;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanDefinitionTest {
//    AnnotationConfigApplicationContext ac  = new AnnotationConfigApplicationContext(AppConfig.class);
    GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
    @Test
    @DisplayName("빈 설정 메타정보 확인")
    void findApplicationbean(){
        String[] beandefinitionnames= ac.getBeanDefinitionNames();
        for(String beandefinitionname: beandefinitionnames){
            BeanDefinition beandefinition= ac.getBeanDefinition(beandefinitionname);

            if(beandefinition.getRole()== beandefinition.ROLE_APPLICATION){
                System.out.println("beandefinitionname="+ beandefinitionname+"beandefinition"+ beandefinition);
       }
   }
}
}

