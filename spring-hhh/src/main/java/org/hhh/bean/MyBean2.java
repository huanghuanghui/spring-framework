package org.hhh.bean;

/**
 * @Author: hhh
 * @Date: 2021/10/6 2:25 下午
 * @Description @Bean 与@Component注册Bean的方式的区别
 * - @Bean会写入factoryBeanName，factoryBeanName为注册他的类，这里为AppConfig，不能与Bean类一致
 * - 会先生成@Bean依赖的配置类，例如这里的AppConfig
 * - 生成的BeanName为@Bean的MethodName
 * - 其他与普通Bean的生成流程一致
 */
public class MyBean2 {

    public void test(){
        System.out.println("----------------myBean2----------------");
    }
}
