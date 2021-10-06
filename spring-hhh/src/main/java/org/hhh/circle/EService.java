package org.hhh.circle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: hhh
 * @Date: 2021/10/4 1:54 下午
 * @Description TODO
 */
public class EService {
    @Autowired
    private FService fService;

    public void test(){
        System.out.println("-------test FService--------");
    }
}
