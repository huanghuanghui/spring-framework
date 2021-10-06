package org.hhh;

import org.hhh.bean.MyBean;
import org.hhh.bean.MyBean2;
import org.hhh.config.AppConfig;
import org.hhh.value.ValueService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

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


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MyBean myBean = context.getBean(MyBean.class);
        MyBean2 myBean2 = context.getBean(MyBean2.class);
        myBean.test();
        myBean2.test();
        //关闭
        context.close();
    }
}
