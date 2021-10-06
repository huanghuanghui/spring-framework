package org.hhh.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;


/**
 * @Author: hhh
 * @Date: 2021/9/28 1:48 下午
 * @Description TODO
 */
@Component
public class BService implements BeanPostProcessor {
    @Autowired
    private AService aService;


    public void test(){
        System.out.println("------------------------------------------------------B Autowired------------------------------------------------------");
        aService.test();

    }
}
