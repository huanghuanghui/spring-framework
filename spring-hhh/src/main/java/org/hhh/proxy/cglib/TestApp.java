package org.hhh.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import org.hhh.proxy.simple1.Leader;

public class TestApp {
    public static void main(String[] args) {
        //保存生成的 class 文件
        // System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\temp\\code");
        // 通过CGLIB动态代理获取代理对象的过程
        Enhancer enhancer = new Enhancer();
        // 设置enhancer对象的父类
        enhancer.setSuperclass(Leader.class);
        // 设置enhancer的回调对象
        enhancer.setCallback(new LeaderMethodInterceptor());
        // 创建代理对象
        Leader proxy= (Leader)enhancer.create();

        // 通过代理对象调用目标方法
        proxy.meeting();
        proxy.evaluate("Joy");
        proxy.evaluate("James");
    }
}
