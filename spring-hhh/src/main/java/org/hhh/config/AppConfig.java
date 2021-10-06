package org.hhh.config;

import org.hhh.bean.MyBean;
import org.hhh.bean.MyBean2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: hhh
 * @Date: 2021/9/28 12:21 下午
 * @Description TODO
 */
@ComponentScan({"org.hhh"})
public class AppConfig {

    @Bean
    public MyBean myBean(){
        return new MyBean();
    }
    @Bean
    public static MyBean2 myBean2(){
        return new MyBean2();
    }

}
