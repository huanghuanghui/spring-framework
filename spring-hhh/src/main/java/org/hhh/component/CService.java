package org.hhh.component;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Author: hhh
 * @Date: 2021/10/3 3:30 下午
 * @Description bean的生命周期
 * Bean的完整生命周期经历了各种方法调用，这些方法可以划分为以下几类：
 *
 * 1、Bean自身的方法　　：　　这个包括了Bean本身调用的方法和通过配置文件中<bean>的init-method和destroy-method指定的方法
 *
 * 2、Bean级生命周期接口方法　　：　　这个包括了BeanNameAware、BeanFactoryAware、InitializingBean和DiposableBean这些接口的方法
 *
 * 3、容器级生命周期接口方法　　：　　这个包括了InstantiationAwareBeanPostProcessor 和 BeanPostProcessor 这两个接口实现，一般称它们的实现类为“后处理器”。
 *
 * 4、工厂后处理器接口方法　　：　　这个包括了AspectJWeavingEnabler, ConfigurationClassPostProcessor, CustomAutowireConfigurer等等非常有用的工厂后处理器　　接口的方法。工厂后处理器也是容器级的。在应用上下文装配配置文件之后立即调用。
 */
//@Component
public class CService implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean, BeanPostProcessor {

    /**
     * 执行顺序：1
     * BeanNameAware
     * doCreateBean#initializeBean#AbstractAutowireCapableBeanFactory#invokeAwareMethods()
     * @param name the name of the bean in the factory.
     * Note that this name is the actual bean name used in the factory, which may
     * differ from the originally specified name: in particular for inner bean
     * names, the actual bean name might have been made unique through appending
     * "#..." suffixes. Use the {@link BeanFactoryUtils#originalBeanName(String)}
     */
    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware setBeanName");
    }
    /**
     * 执行顺序：2
     * BeanFactoryAware
     * doCreateBean#initializeBean#AbstractAutowireCapableBeanFactory#invokeAwareMethods()
     * @param beanFactory owning BeanFactory (never {@code null}).
     * The bean can immediately call methods on the factory.
     * @throws BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware setBeanFactory");
    }

    /**
     * 本类不执行自己注册的beanPostProcessors，详细解释见org/springframework/context/support/PostProcessorRegistrationDelegate.java:282
     * 执行顺序：3
     * BeanPostProcessor doCreateBean#initializeBean#applyBeanPostProcessorsBeforeInitialization执行
     * @param bean the new bean instance
     * @param beanName the name of the bean
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor/postProcessBeforeInitialization/"+beanName);
        return bean;
    }

    /**
     * 执行顺序：4
     * InitializingBean
     *
     * doCreateBean#initializeBean#AbstractAutowireCapableBeanFactory#invokeInitMethods
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean afterPropertiesSet");
    }

    /**
     * 本类不执行自己注册的beanPostProcessors，详细解释见org/springframework/context/support/PostProcessorRegistrationDelegate.java:282
     * 执行顺序：5
     * BeanPostProcessor doCreateBean#initializeBean#applyBeanPostProcessorsBeforeInitialization执行
     * BeanPostProcessor initializeBean执行
     * @param bean the new bean instance
     * @param beanName the name of the bean
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor/postProcessAfterInitialization/"+beanName);
        return bean;
    }

    /**
     * DisposableBean
     * @throws Exception
     */

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean destroy");
    }
}
