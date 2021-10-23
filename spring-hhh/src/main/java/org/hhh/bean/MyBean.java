package org.hhh.bean;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: hhh
 * @Date: 2021/10/6 2:25 下午
 * @Description @Bean 与@Component注册Bean的方式的区别
 * - @Bean会写入factoryBeanName，factoryBeanName为注册他的类，这里为AppConfig，不能与Bean类一致
 * - 会先生成@Bean依赖的配置类，例如这里的AppConfig
 * - 生成的BeanName为@Bean的MethodName
 * - 其他与普通Bean的生成流程一致
 * - 如果以静态方法方式注册bean，也会生成正常的bean，生成bean对象实例的时候会判断是否为静态方法，为静态方法，
 *      走org/springframework/beans/factory/support/ConstructorResolver.java:494，使用反射直接调用静态方法生成bean
 */
public class MyBean {


    public void test(String user, String password){
        System.out.println("----------------myBean----------------"+user+"/"+password);
    }
}
