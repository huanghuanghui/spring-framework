package org.hhh.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class LeaderMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if ("meeting".equals(method.getName())) {
            System.out.println("代理先准备会议材料...");
            return methodProxy.invokeSuper(o, objects);
        } else if ("evaluate".equals(method.getName())) {
            if(objects[0] instanceof String) {
                if ("James".equals(objects[0])) {
                    System.out.println("James 犯过错误，所以考评分数较低...");
                    return 70;
                }
            }
            return methodProxy.invokeSuper(o, objects);
        }
        return null;
    }
}