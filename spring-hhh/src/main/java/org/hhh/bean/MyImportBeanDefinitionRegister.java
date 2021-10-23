package org.hhh.bean;

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
 * @Description TODO
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
