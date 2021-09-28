/*
 * Copyright 2002-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.beans.factory.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.lang.Nullable;

/**
 *
 * {@link BeanPostProcessor} 的子接口，它添加了实例化前回调，以及实例化后但在设置显式属性或自动装配之前的回调。
 * <p>通常用于抑制特定目标 bean 的默认实例化，例如创建具有特殊 TargetSources 的代理（池化目标、延迟初始化目标等），
 * 或实现额外的注入策略，例如字段注入。 <p><b>注意：<b>这个接口是一个特殊用途的接口，主要供框架内部使用。
 * 建议尽量实现普通的{@link BeanPostProcessor}接口，或者派生自{@link InstantiationAwareBeanPostProcessorAdapter}，以屏蔽对该接口的扩展。
 *
 * <a @link #https://blog.csdn.net/qq_38526573/article/details/88091702></a>
 *
 * Subinterface of {@link BeanPostProcessor} that adds a before-instantiation callback,
 * and a callback after instantiation but before explicit properties are set or
 * autowiring occurs.
 *
 * <p>Typically used to suppress default instantiation for specific target beans,
 * for example to create proxies with special TargetSources (pooling targets,
 * lazily initializing targets, etc), or to implement additional injection strategies
 * such as field injection.
 *
 * <p><b>NOTE:</b> This interface is a special purpose interface, mainly for
 * internal use within the framework. It is recommended to implement the plain
 * {@link BeanPostProcessor} interface as far as possible.
 *
 * @author Juergen Hoeller
 * @author Rod Johnson
 * @since 1.2
 * @see org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator#setCustomTargetSourceCreators
 * @see org.springframework.aop.framework.autoproxy.target.LazyInitTargetSourceCreator
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {

	/**
	 * 自身方法，是最先执行的方法，它在目标对象实例化之前调用，该方法的返回值类型是Object，我们可以返回任何类型的值。
	 * 由于这个时候目标对象还未实例化，所以这个返回值可以用来代替原本该生成的目标对象的实例(比如代理对象)。
	 * 如果该方法的返回值代替原本该生成的目标对象，后续只有postProcessAfterInitialization方法会调用，其它方法不再调用；否则按照正常的流程走
	 *
	 *
	 * 在目标 bean 被实例化之前<i>应用这个 BeanPostProcessor<i>。返回的 bean 对象可能是一个代理来代替目标 bean，
	 * 有效地抑制目标 bean 的默认实例化。 <p>如果这个方法返回了一个非空的对象，那么bean的创建过程就会短路。
	 * 唯一应用的进一步处理是来自配置的 {@link BeanPostProcessor BeanPostProcessors}
	 * 的 {@link #postProcessAfterInitialization} 回调。
	 * <p>此回调将应用于带有 bean 类的 bean 定义，以及工厂方法定义，在这种情况下，将在此处传递返回的 bean 类型。
	 * <p>后处理器可以实现扩展的 {@link SmartInstantiationAwareBeanPostProcessor} 接口，
	 * 以预测它们将在此处返回的 bean 对象的类型。 <p>默认实现返回 {@code null}。
	 *
	 * Apply this BeanPostProcessor <i>before the target bean gets instantiated</i>.
	 * The returned bean object may be a proxy to use instead of the target bean,
	 * effectively suppressing default instantiation of the target bean.
	 * <p>If a non-null object is returned by this method, the bean creation process
	 * will be short-circuited. The only further processing applied is the
	 * {@link #postProcessAfterInitialization} callback from the configured
	 * {@link BeanPostProcessor BeanPostProcessors}.
	 * <p>This callback will be applied to bean definitions with their bean class,
	 * as well as to factory-method definitions in which case the returned bean type
	 * will be passed in here.
	 * <p>Post-processors may implement the extended
	 * {@link SmartInstantiationAwareBeanPostProcessor} interface in order
	 * to predict the type of the bean object that they are going to return here.
	 * <p>The default implementation returns {@code null}.
	 * @param beanClass the class of the bean to be instantiated
	 * @param beanName the name of the bean
	 * @return the bean object to expose instead of a default instance of the target bean,
	 * or {@code null} to proceed with default instantiation
	 * @throws org.springframework.beans.BeansException in case of errors
	 * @see #postProcessAfterInstantiation
	 * @see org.springframework.beans.factory.support.AbstractBeanDefinition#getBeanClass()
	 * @see org.springframework.beans.factory.support.AbstractBeanDefinition#getFactoryMethodName()
	 */
	@Nullable
	default Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		return null;
	}

	/**
	 *
	 * 在目标对象实例化之后调用，这个时候对象已经被实例化，但是该实例的属性还未被设置，都是null。
	 * 因为它的返回值是决定要不要调用postProcessPropertyValues方法的其中一个因素（因为还有一个因素是mbd.getDependencyCheck()）；
	 * 如果该方法返回false,并且不需要check，那么postProcessPropertyValues就会被忽略不执行；如果返回true，
	 * postProcessProperties就会被执行

	 * Perform operations after the bean has been instantiated, via a constructor or factory method,
	 * but before Spring property population (from explicit properties or autowiring) occurs.
	 * <p>This is the ideal callback for performing custom field injection on the given bean
	 * instance, right before Spring's autowiring kicks in.
	 * <p>The default implementation returns {@code true}.
	 * @param bean the bean instance created, with properties not having been set yet
	 * @param beanName the name of the bean
	 * @return {@code true} if properties should be set on the bean; {@code false}
	 * if property population should be skipped. Normal implementations should return {@code true}.
	 * Returning {@code false} will also prevent any subsequent InstantiationAwareBeanPostProcessor
	 * instances being invoked on this bean instance.
	 * @throws org.springframework.beans.BeansException in case of errors
	 * @see #postProcessBeforeInstantiation
	 */
	default boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		return true;
	}

	/**
	 * Post-process the given property values before the factory applies them
	 * to the given bean.
	 * <p>The default implementation returns the given {@code pvs} as-is.
	 * @param pvs the property values that the factory is about to apply (never {@code null})
	 * @param bean the bean instance created, but whose properties have not yet been set
	 * @param beanName the name of the bean
	 * @return the actual property values to apply to the given bean (can be the passed-in
	 * PropertyValues instance), or {@code null} to skip property population
	 * @throws org.springframework.beans.BeansException in case of errors
	 * @since 5.1
	 */
	@Nullable
	default PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName)
			throws BeansException {

		return pvs;
	}

}
