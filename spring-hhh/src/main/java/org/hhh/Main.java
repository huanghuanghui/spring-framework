package org.hhh;

import org.hhh.bean.TestService;
import org.hhh.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: hhh
 * @Date: 2021/9/28 12:18 下午
 * @Description TODO
 */
@ComponentScan
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TestService bean = context.getBean(TestService.class);
        bean.test();
    }
}
