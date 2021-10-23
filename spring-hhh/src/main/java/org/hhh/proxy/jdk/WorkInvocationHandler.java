package org.hhh.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 通过InvocationHandler生成的代理类，对类进行代理
 */
public class WorkInvocationHandler implements InvocationHandler {
    private Object object;

    public WorkInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("object: " + object.getClass().getSimpleName());
        System.out.println("proxy: " + proxy.getClass().getSimpleName());

        if ("meeting".equals(method.getName())) {
            System.out.println("代理先准备会议材料...");
            return method.invoke(object, args);
        } else if ("evaluate".equals(method.getName())) {
            if(args[0] instanceof String) {
                if ("James".equals(args[0])) {
                    System.out.println("James 犯过错误，所以考评分数较低...");
                    return 70;
                }
            }
            return method.invoke(object, args);
        }
        return null;
    }
}