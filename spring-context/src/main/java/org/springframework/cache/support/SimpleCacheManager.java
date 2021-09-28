/*
 * Copyright 2002-2020 the original author or authors.
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

package org.springframework.cache.support;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.cache.Cache;

import javax.ejb.Init;

/**
 * Simple cache manager working against a given collection of caches.
 * Useful for testing or simple caching declarations.
 * <p>
 * When using this implementation directly, i.e. not via a regular
 * bean registration, {@link #initializeCaches()} should be invoked
 * to initialize its internal state once the
 * {@linkplain #setCaches(Collection) caches have been provided}.
 *
 * @author Costin Leau
 * @since 3.1
 */
public class SimpleCacheManager extends AbstractCacheManager implements InstantiationAwareBeanPostProcessor {


	public SimpleCacheManager(){
		System.out.println("开始执行----->SimpleCacheManager构造方法执行");
	}

	private String name;

	private Collection<? extends Cache> caches = Collections.emptySet();


	/**
	 * Specify the collection of Cache instances to use for this CacheManager.
	 * @see #initializeCaches()
	 */
	public void setCaches(Collection<? extends Cache> caches) {
		this.caches = caches;
	}

	@Override
	protected Collection<? extends Cache> loadCaches() {
		return this.caches;
	}

	/**
	 * 表示初始化,对象已经生成
	 * @param bean the new bean instance
	 * @param beanName the name of the bean
	 * @return
	 * @throws BeansException
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(beanName+"开始执行----------------->postProcessBeforeInitialization");
		return bean;
	}

	/**
	 * 表示初始化,对象已经生成
	 * @param bean the new bean instance
	 * @param beanName the name of the bean
	 * @return
	 * @throws BeansException
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(beanName+"开始执行----------------->postProcessAfterInitialization");
		return bean;
	}

	/**
	 * 表示初始化,对象已经生成
	 * @param beanClass the class of the bean to be instantiated
	 * @param beanName the name of the bean
	 * @return
	 * @throws BeansException
	 */
	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		System.out.println(beanName+"开始执行----------------->postProcessBeforeInstantiation");
		return null;
	}

	/**
	 * 表示初始化,对象已经生成 在#AbstractAutowireCapableBeanFactory#getBean resolveBeforeInstantiation 让方法有机会返回一个代理对象
	 * @param bean the bean instance created, with properties not having been set yet
	 * @param beanName the name of the bean
	 * @return
	 * @throws BeansException
	 */
	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		System.out.println(beanName+"开始执行----------------->postProcessAfterInstantiation");
		return true;
	}

	@Override
	public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
		System.out.println(beanName+"开始执行----------------->postProcessProperties");
		return null;
	}

}
