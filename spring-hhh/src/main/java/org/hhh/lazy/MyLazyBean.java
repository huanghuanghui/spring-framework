package org.hhh.lazy;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @Author: hhh
 * @Date: 2021/10/23 11:15 下午
 * @Description TODO
 */
//@Component
public class MyLazyBean implements InitializingBean {



    public void test(){
        System.out.println("------myLazyBean------");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("-----------afterPropertiesSet---------");
    }
}
