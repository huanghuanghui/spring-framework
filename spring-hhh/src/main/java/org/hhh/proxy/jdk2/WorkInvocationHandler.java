package org.hhh.proxy.jdk2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class WorkInvocationHandler implements InvocationHandler {
    private Object object;

    public WorkInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("work".equals(method.getName())){
            System.out.println("--- work: " + args[0]);
            return proxy;
        }
        return object;
    }
}