package org.hhh.bean.byname;

import org.hhh.bean.MyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: hhh
 * @Date: 2021/10/20 5:31 下午
 * @Description TODO
 */
@Component
public class MyBeanByName2 {
    private MyBean myBean;

    @Autowired
    public void setMyBean(MyBean myBean) {
        System.out.println("-------autowired mode by Name------set myBean");
        this.myBean = myBean;
    }

    public MyBean getMyBean() {
        return myBean;
    }
}
