package context.annotation;

import beans.factory.config.BeanDefinition;
import cn.hutool.core.util.ClassUtil;
import stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/15
 * @Copyright： yyyan.icu
 */
public class ClassPathScanningCandidateComponentProvider {

    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }
}
