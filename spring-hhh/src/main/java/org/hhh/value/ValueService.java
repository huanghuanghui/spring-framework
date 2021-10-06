package org.hhh.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ConfigurableBeanFactory#setBeanExpressionResolver(BeanExpressionResolver)
 *
 * 添加bean表达式解释器，为了能够让我们的beanFactory去解析bean表达式
 * 模板默认以前缀“#{”开头，以后缀“}”结尾【@Value("#{}")与@Value("${}")】
 * 可以修改默认额前缀后缀
 * 通过beanFactory.getBeanExpressionResolver()获得BeanExpressionResolver
 * 然后resolver.setExpressionPrefix("%{");resolver.setExpressionSuffix("}");
 *
 * 那么什么时候用到这个解析器？
 * 就是在Bean进行初始化后会有属性填充的一步,方法如下:
 * protected void populateBean(String beanName, RootBeanDefinition mbd, BeanWrapper bw) {
 * 	//属性填充
 * 	applyPropertyValues(beanName, mbd, bw, pvs);
 * }
 * 最终会通过AbstractBeanFactory中的evaluateBeanDefinitionString方法进行解析
 * 然后这时候就进到StandardBeanExpressionResolver中的evaluate方法中进行解析了
 *
 * - @Value(“#{}”) 表示SpEl表达式通常用来获取bean的属性，或者调用bean的某个方法。当然还有可以表示常量 @Value(“#{dataSource.url}”
 * - 用 @Value(“${xxxx}”)注解从配置文件读取值的用法
 */
@Component
public class ValueService {

    @Value("${hhh.name}")
    private String name;

    public void getName(){
        System.out.println("------------name:"+name+"----------------");
    }
}
