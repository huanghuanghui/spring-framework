//package org.hhh.proxy.jdk2;
//
//import java.lang.reflect.Proxy;
//
///**
// * new WorkInvocationHandler(new IWork2() 会将返回的类的代理对象传入
// */
//public class TestApp {
//    public static void main(String[] args) {
//
//
//        IWork2 object = new IWork2() {
//            @Override
//            public IWork2 work(String subject) {
//                return null;
//            }
//        };
//
//        IWork2 worker = (IWork2) Proxy.newProxyInstance(
//                IWork2.class.getClassLoader(),
//              IWork2.class.getInterfaces(), new WorkInvocationHandler(object));
//        worker.work("AAA").work("BBB").work("CCC");
//    }
//
//}