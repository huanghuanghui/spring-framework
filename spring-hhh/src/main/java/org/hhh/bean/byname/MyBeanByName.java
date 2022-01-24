package org.hhh.bean.byname;

import org.hhh.bean.MyBean;

/**
 * @Author: hhh
 * @Date: 2021/10/20 5:31 下午
 * @Description TODO
 */
public class MyBeanByName {
    private MyBean myBean;

    public void setMyBean(MyBean myBean) {
        System.out.println("-------autowired mode by Name------set myBean");
        this.myBean = myBean;
    }

    public MyBean getMyBean() {
        return myBean;
    }
}
