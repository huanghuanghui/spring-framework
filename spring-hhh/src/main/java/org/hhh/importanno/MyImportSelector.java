package org.hhh.importanno;

import org.hhh.component.DService;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * @Author: hhh
 * @Date: 2021/10/21 2:58 下午
 * @Description TODO
 */
public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(EnableMyImportSelector.class.getName(), true);
        return new String[]{DService.class.getName()};
    }

    public String getMyImportSelector(){
        return "getMyImportSelector";
    }
}
