//package org.hhh.proxy.jdk;
//
//import org.hhh.proxy.simple1.IWork;
//import org.hhh.proxy.simple1.Leader;
//
//import java.lang.reflect.Proxy;
//
///**
// * 我们看到，通过 WorkInvocationHandler 类，我们同样可以代理 Leader 类的方法的实现，
// * 实际上我们实现的是任意的方法的实现，只是我们在创建代理对象的时候传入的是 Iwork 接口以及 Leader 类对象。
// * 这里需要注意的是：在 InvocationHandler 接口的 invoke 方法中第一个参数 proxy,
// * 并不是我们调用方法的对象，那这个参数是什么呢？代码中，我特别增加相应打印，
// * 打印出了 proxy 的类名，实际上 proxy 是代理对象本身，它的意义在于，我们可以在 invoke 方法中，
// * 返回该代理对象，然后进行连续调用。
// */
//public class TestApp {
//    public static void main(String[] args) {
//        Leader leader = new Leader();
//        IWork proxy = (IWork) Proxy.newProxyInstance(
//                Leader.class.getClassLoader(),
//                IWork.class.getInterfaces(),
//                new WorkInvocationHandler(leader));
//        proxy.meeting();
//        proxy.evaluate("Joy");
//        proxy.evaluate("James");
//    }
//}