package org.hhh.mycomponet;

import org.springframework.stereotype.Component;

/**
 * @Author: hhh
 * @Date: 2022/1/20 11:20 上午
 * @Description TODO
 */
@Component
public class Student {

    private String name;

    public void test(){
        System.out.println("test #Student");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
