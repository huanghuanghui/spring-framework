/*
 * Copyright 2002-2012 the original author or authors.
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

package org.springframework.beans;

import java.beans.PropertyEditor;

import org.springframework.lang.Nullable;

/**
 * 封装用于注册 JavaBeans {@link PropertyEditor PropertyEditors} 的方法。这是 {@link PropertyEditorRegistrar} 操作的核心接口。
 * Encapsulates methods for registering JavaBeans {@link PropertyEditor PropertyEditors}.
 * This is the central interface that a {@link PropertyEditorRegistrar} operates on.
 *
 * <p>Extended by {@link BeanWrapper}; implemented by {@link BeanWrapperImpl}
 * and {@link org.springframework.validation.DataBinder}.
 *
 * @author Juergen Hoeller
 * @since 1.2.6
 * @see java.beans.PropertyEditor
 * @see PropertyEditorRegistrar
 * @see BeanWrapper
 * @see org.springframework.validation.DataBinder
 */
public interface PropertyEditorRegistry {

	/**
	 * 为给定类型的所有属性注册给定的自定义属性编辑器。
	 * Register the given custom property editor for all properties of the given type.
	 * @param requiredType the type of the property
	 * @param propertyEditor the editor to register
	 */
	void registerCustomEditor(Class<?> requiredType, PropertyEditor propertyEditor);

	/**
	 * 为给定的类型和属性或给定类型的所有属性注册给定的自定义属性编辑器。
	 * <p>如果属性路径表示数组或集合属性，则编辑器将应用于数组集合本身（{@link PropertyEditor} 必须创建数组或集合值）
	 * 或每个元素（{@code PropertyEditor } 必须创建元素类型），具体取决于指定的所需类型。
	 * <p>注意：每个属性路径仅支持一个注册的自定义编辑器。
	 * 在 Collectionarray 的情况下，不要为 Collectionarray 和同一属性上的每个元素注册编辑器。
	 * <p>例如，如果您想为“items[n].quantity”（对于所有值 n）注册一个编辑器，
	 * 您可以使用“items.quantity”作为此方法的“propertyPath”参数的值。
	 * @param requiredType 属性的类型。如果给出了属性，则这可能是 {@code null}，
	 * 但在任何情况下都应指定，特别是在 Collection 的情况下 -
	 * 明确编辑器是应该应用于整个 Collection 本身还是应用于其中的每个条目。
	 * 所以作为一般规则：<b>如果是 Collectionarray，请不要在此处指定 {@code null}！<b>
	 * Register the given custom property editor for the given type and
	 * property, or for all properties of the given type.
	 * <p>If the property path denotes an array or Collection property,
	 * the editor will get applied either to the array/Collection itself
	 * (the {@link PropertyEditor} has to create an array or Collection value) or
	 * to each element (the {@code PropertyEditor} has to create the element type),
	 * depending on the specified required type.
	 * <p>Note: Only one single registered custom editor per property path
	 * is supported. In the case of a Collection/array, do not register an editor
	 * for both the Collection/array and each element on the same property.
	 * <p>For example, if you wanted to register an editor for "items[n].quantity"
	 * (for all values n), you would use "items.quantity" as the value of the
	 * 'propertyPath' argument to this method.
	 * @param requiredType the type of the property. This may be {@code null}
	 * if a property is given but should be specified in any case, in particular in
	 * case of a Collection - making clear whether the editor is supposed to apply
	 * to the entire Collection itself or to each of its entries. So as a general rule:
	 * <b>Do not specify {@code null} here in case of a Collection/array!</b>
	 * @param propertyPath the path of the property (name or nested path), or
	 * {@code null} if registering an editor for all properties of the given type
	 * @param propertyEditor editor to register
	 */
	void registerCustomEditor(@Nullable Class<?> requiredType, @Nullable String propertyPath, PropertyEditor propertyEditor);

	/**
	 * 为给定的类型和属性找到一个自定义属性编辑器。
	 * Find a custom property editor for the given type and property.
	 * @param requiredType the type of the property (can be {@code null} if a property
	 * is given but should be specified in any case for consistency checking)
	 * @param propertyPath the path of the property (name or nested path), or
	 * {@code null} if looking for an editor for all properties of the given type
	 * @return the registered editor, or {@code null} if none
	 */
	@Nullable
	PropertyEditor findCustomEditor(@Nullable Class<?> requiredType, @Nullable String propertyPath);

}
