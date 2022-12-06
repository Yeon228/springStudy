package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        //스캔 기본값 -> AppConfig이 속한 패키지의 하위 파일 탐색
        //basePackages = "hello.core", //해당 패키지 아래로 탐색
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)//Configuration Annotation 이 등록된 클래스는 등록 x ex)AppConfig,TestConfig..
)
public class AutoAppConfig {
    //auto wired 기능 사용
}