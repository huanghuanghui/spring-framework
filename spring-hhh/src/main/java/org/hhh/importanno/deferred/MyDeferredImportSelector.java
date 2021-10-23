package org.hhh.importanno.deferred;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.function.Predicate;

/**
 * @Author: hhh
 * @Date: 2021/10/21 5:09 下午
 * @Description spring boot 自动装配
 */
public class MyDeferredImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[0];
    }

    /**
     * 要使用DeferredImportSelector 就要实现下面的getImportGroup方法，
     * 并要写一个实现Group接口的 类，该方法返回一个Class，
     * 	表示当前DeferredImportSelector 属于哪个组的，
     * 	spring会生成唯一的Group，并将返回值为该Group的DeferredImportSelector 放入一个List里
     * @return
     */
    @Override
    public Class<? extends Group> getImportGroup() {
        return null;
    }

    @Override
    public Predicate<String> getExclusionFilter() {
        return null;
    }
}
