package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)//Configuration Annotation 이 등록된 클래스는 등록 x ex)AppConfig,TestConfig..
)
public class AutoAppConfig {
    //auto wired 기능 사용

}