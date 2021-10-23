package org.hhh.component;


import org.hhh.bean.MyBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: hhh
 * @Date: 2021/10/3 4:11 下午
 * @Description bean的创建与销毁
 * 方式1：
 * @Bean(initMethod = "init",destroyMethod = "destroy")
 *     public DService dService(){
 *         return new DService();
 *     }
 *方式2：
 * @Component+@PostConstruct+@PreDestroy
 *
 * @Bean(initMethod = "init",destroyMethod = "destroy")中的initMethod=@PostConstruct destroyMethod=@PreDestroy
 * initMethod：
 *      AbstractAutowireCapableBeanFactory#doCreateBean#initializeBean#invokeCustomInitMethod()：1940
 *      initMethod会被解析为RootBeanDefinition的initMethodName
 *      不能是InitializingBean&&不能是afterPropertiesSet方法，否则会失效
 *
 * destroyMethod
 *      spring application context close 的时候会进行回调
 */
public class DService {

    @Autowired
    private MyBean myBean;

    public MyBean getMyBean() {
        return myBean;
    }

    /**
     * 执行顺序 1
     *构造
     */
    public DService() {
        System.out.println("DService--------construct");
    }
    /**
     * 执行顺序 2
     * AbstractAutowireCapableBeanFactory#doCreateBean#initializeBean#invokeCustomInitMethod()：1940
     */
    public void init(){
        System.out.println("DService--------init");
    }



    /**
     *  执行顺序 3
     * AnnotationConfigApplicationContext.close 才会调用
     * 解析为：DisposableBeanAdapter#destroyMethod属性，在调用context.close的时候，会被执行
     */
    public void destroy(){
        System.out.println("DService--------destroy");
    }
}
