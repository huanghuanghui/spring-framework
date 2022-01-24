package org.hhh.lazy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Author: hhh
 * @Date: 2021/10/23 11:16 下午
 * @Description TODO
 * Lazy 分为2种情况：
 *  1 打在类上，会使类延迟加载，延迟加载的做法是，在refresh preInstantiateSingletons装载bean的时候，
 *      !bd.isAbstract() && bd.isSingleton() && !bd.isLazyInit()，判断bean是否为lazy，为lazy，会跳过getBean，等到bean真正被使用
 *      的时候才会被加载（被依赖注入（@Autowired/@Resource）/手动调用getBean）
 *  2 打在被注入的属性上，如本例展示，这种情况，会在ContextAnnotationAutowireCandidateResolver#getLazyResolutionProxyIfNecessary
 *      判断是否是lazy的属性，如果是lazy属性，被依赖注入的类，将会是一个代理类，通过@Lazy注解能够解决很多情况下的循环依赖问题，它的基本思想是先
 *      ’随便’给你创建一个代理对象先放着，等你真正执行方法的时候再实际去容器内找出目标实例执行
 */
@Component
public class UseMyLazyBean {
    @Autowired
    @Lazy
    private MyLazyBean myLazyBean;


    public void test(){
        myLazyBean.test();
    }
}
