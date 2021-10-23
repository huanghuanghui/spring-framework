package org.hhh.proxy.simple1;

/**
 装饰器模式关注于在一个对象上动态的添加方法，然而代理模式关注于控制对对象的访问。
 换句话说，用代理模式，代理类（proxy class）可以对它的客户隐藏一个对象的具体信息。
 因此，当使用代理模式的时候，我们常常在一个代理类中创建一个对象的实例。
 并且，当我们使用装饰器模式的时候，我们通常的做法是将原始对象作为一个参数传给装饰者的构造器。

 代理模式和装饰者模式侧重点不一样，代理模式重点在于明确了被代理的类。
 如上例中，秘书很明确要代理的是的领导。
 而装饰者模式侧重于拓展类的方法，装饰类持有的实现Component接口的类的对象不是固定的，
 也就是说，装饰类可以根据在调用时传入的参数，装饰任意一个实现了 Component 接口的类。
 *
 */
public class TestApp {
    public static void main(String[] args) {
        Leader leader = new Leader();
        Secretary secretary = new Secretary(leader);
        secretary.meeting();
        secretary.evaluate("Joy");
    }
}