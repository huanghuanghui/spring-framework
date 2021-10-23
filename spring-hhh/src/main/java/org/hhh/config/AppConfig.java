package org.hhh.config;

import org.hhh.bean.MyBean;
import org.hhh.bean.MyBean2;
import org.hhh.bean.MyImportBeanDefinitionRegister;
import org.hhh.bean.SqlSessionConfig;
import org.hhh.importanno.EnableMyImportSelector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

/**
 * @Author: hhh
 * @Date: 2021/9/28 12:21 下午
 * @Description TODO
 */
@ComponentScan({"org.hhh"})
@Import({MyImportBeanDefinitionRegister.class})
@EnableMyImportSelector(name = "hhhh")
public class AppConfig {

    @Bean
    @Lazy
    public MyBean myBean(SqlSessionConfig sqlSessionConfig){
        MyBean myBean = new MyBean();
        myBean.test(sqlSessionConfig.getName(),sqlSessionConfig.getPassword());
        return myBean;
    }

}
