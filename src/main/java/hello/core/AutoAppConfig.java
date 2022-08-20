package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
@Configuration
@ComponentScan(
        basePackages = {"hello.core"} , // 대상 하위 패키지에서만 컴포넌트 스캔
        basePackageClasses = AutoAppConfig.class, // 해당 클래스의 패키지의 하위 파일들 스캔
        //Default @ComponetScan 이 붙은 패키지의 하위 파일 모두 탐색
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
