package org.hhh;

import org.hhh.bean.MyBean;
import org.hhh.bean.MyBean2;
import org.hhh.bean.byname.MyBeanByName;
import org.hhh.bean.byname.MyBeanByName2;
import org.hhh.bean.bytype.MyBeanByType;
import org.hhh.component.DService;
import org.hhh.component.GService;
import org.hhh.config.AppConfig;
import org.hhh.importanno.MyImportSelector;
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
        /**
         * 第一种扫描
         */
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MyBeanByName bean = context.getBean(MyBeanByName.class);
        System.out.println(bean.getMyBean());

        MyBeanByType bean2 = context.getBean(MyBeanByType.class);
        System.out.println(bean2.getXXXXX());

        MyBeanByName2 bean3 = context.getBean(MyBeanByName2.class);
        System.out.println(bean3.getMyBean());

        DService dService = context.getBean(DService.class);
        System.out.println(dService.getMyBean()+"dService");
        MyImportSelector myImportSelector = context.getBean(MyImportSelector.class);
        System.out.println(myImportSelector.getMyImportSelector()+"myImportSelector");
    }
}
