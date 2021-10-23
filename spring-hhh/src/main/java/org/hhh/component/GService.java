package org.hhh.component;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Author: hhh
 * @Date: 2021/9/28 12:21 下午
 * @Description TODO
 */
//@Component
public class GService implements BeanPostProcessor {

    public void test(){
        System.out.println("-----------testG------------");
    }

}
