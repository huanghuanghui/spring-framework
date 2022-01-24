package org.hhh.config;

import org.hhh.bean.MyBean;
import org.hhh.bean.MyBean2;
import org.hhh.bean.MyImportBeanDefinitionRegister;
import org.hhh.bean.SqlSessionConfig;
import org.hhh.importanno.EnableMyImportSelector;
import org.hhh.lazy.MyLazyBean;
import org.hhh.mycomponet.MyNameGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @Author: hhh
 * @Date: 2021/9/28 12:21 下午
 * @Description TODO
 */
@ComponentScan(value = "org.hhh",lazyInit = true)
public class AppConfig {

}
