package org.hhh.importanno;

import org.hhh.bean.byname.MyBeanByName;
import org.hhh.bean.bytype.MyBeanByType;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: hhh
 * @Date: 2021/10/20 5:33 下午
 * @Description @Import的三种方式， @Import引入的类，会被spring处理，生成对应的bean definition，支持spring其他bean的所有特性，aop/ioc
 * 1.直接@Import({UserService.class})，将类的bean注入到spring 容器中
 * 2.重写ImportBeanDefinitionRegistrar，@Import({MyImportBeanDefinitionRegister.class})
 * 3.通过ImportSelector方式注入Bean 这种方式要注意，他不扫描implement ImportSelector的类上的Import相关注解，只扫描配置类上与返回的配置类上的
 *
 */
public class MyImportBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        BeanDefinitionBuilder beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(MyBeanByName.class);
        beanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_NAME);
        BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition.getBeanDefinition(), registry);

        BeanDefinitionBuilder beanDefinition2 = BeanDefinitionBuilder.rootBeanDefinition(MyBeanByType.class);
        beanDefinition2.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
        BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition2.getBeanDefinition(), registry);
    }
}
