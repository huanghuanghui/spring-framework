/*
 * Copyright 2002-2019 the original author or authors.
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

package org.springframework.core;

/**
 * {@link Ordered} 接口的扩展，表示 <em>priority<em> 排序：{@code PriorityOrdered}
 * 对象总是在 <em>plain<em> {@link Ordered} 对象之前应用，而不管它们的顺序值如何。
 * <p>在对一组 {@code Ordered} 对象进行排序时，{@code PriorityOrdered} 对象和 <em>plain<em>
 *     {@code Ordered} 对象被有效地视为两个独立的子集，{@code PriorityOrdered} 对象位于 <em>plain<em>
 *         {@code Ordered} 对象集合之前，并且在这些子集中应用了相对顺序。 <p>这主要是一个特殊用途的接口，
 *         在框架本身内用于那些特别重要的对象，首先识别<em>优先<em>对象，甚至可能不需要获取剩余的对象。
 *         一个典型的例子：Spring {@link org.springframework.context.ApplicationContext} 中的优先后处理器。
 *         <p>注意：{@code PriorityOrdered} 后处理器 bean 在特殊阶段初始化，在其他后处理器 bean 之前。
 *         这会微妙地影响它们的自动装配行为：它们只会针对不需要预先初始化进行类型匹配的 bean 自动装配。
 * Extension of the {@link Ordered} interface, expressing a <em>priority</em>
 * ordering: {@code PriorityOrdered} objects are always applied before
 * <em>plain</em> {@link Ordered} objects regardless of their order values.
 *
 * <p>When sorting a set of {@code Ordered} objects, {@code PriorityOrdered}
 * objects and <em>plain</em> {@code Ordered} objects are effectively treated as
 * two separate subsets, with the set of {@code PriorityOrdered} objects preceding
 * the set of <em>plain</em> {@code Ordered} objects and with relative
 * ordering applied within those subsets.
 *
 * <p>This is primarily a special-purpose interface, used within the framework
 * itself for objects where it is particularly important to recognize
 * <em>prioritized</em> objects first, potentially without even obtaining the
 * remaining objects. A typical example: prioritized post-processors in a Spring
 * {@link org.springframework.context.ApplicationContext}.
 *
 * <p>Note: {@code PriorityOrdered} post-processor beans are initialized in
 * a special phase, ahead of other post-processor beans. This subtly
 * affects their autowiring behavior: they will only be autowired against
 * beans which do not require eager initialization for type matching.
 *
 * @author Juergen Hoeller
 * @author Sam Brannen
 * @since 2.5
 * @see org.springframework.beans.factory.config.PropertyOverrideConfigurer
 * @see org.springframework.beans.factory.config.PropertyPlaceholderConfigurer
 */
public interface PriorityOrdered extends Ordered {
}
