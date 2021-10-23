package org.hhh.bean.bytype;

import org.hhh.bean.MyBean;

/**
 * @Author: hhh
 * @Date: 2021/10/20 5:31 下午
 * @Description TODO
 */
public class MyBeanByType {
    private MyBean myBean;

    public void setXXXXX(MyBean myBean) {
        System.out.println("-------autowired mode by Type------set myBean");
        this.myBean = myBean;
    }

    public MyBean getXXXXX() {
        return myBean;
    }
}
