package org.hhh.config;

import org.hhh.bean.MyBean;
import org.hhh.mycomponet.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: hhh
 * @Date: 2021/9/28 12:21 下午
 * @Description TODO
 */
@Configuration
public class AppConfiguration {

    @Bean
    public MyBean myBean(){
        return new MyBean();
    }


    public void test(){
        System.out.println("------------------------AppConfiguration test 方法被调用------------------------");
    }
}
