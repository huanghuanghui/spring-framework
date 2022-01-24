package org.hhh;

import org.hhh.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: hhh
 * @Date: 2021/9/28 12:18 下午
 * @Description TODO
 */
public class Main {
//    @Autowired
    //    @Value()
    //    @ComponentScan
    //    @Component
    //@Resource
//@PostConstruct
//@PreDestroy
//    @Lookup
//    @DependsOn
//    @Primary
//    @Qualifier
//    @Conditional()
//    @Bean
//    @Lazy
//    @Profile()
//    @Service
//    @Import()

//    processCommonDefinitionAnnotations中的@Lazy @Primary @DependsOn @Role

    
    public static void main(String[] args){
        new AnnotationConfigApplicationContext(AppConfig.class);
    }
}
