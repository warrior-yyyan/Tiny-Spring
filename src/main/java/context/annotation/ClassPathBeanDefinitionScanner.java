package context.annotation;

import beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import beans.factory.config.BeanDefinition;
import beans.factory.support.BeanDefinitionRegistry;
import cn.hutool.core.util.StrUtil;
import stereotype.Component;

import java.util.Set;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/15
 * @Copyright： yyyan.icu
 */
public class ClassPathBeanDefinitionScanner extends ClassPathScanningCandidateComponentProvider{

    private BeanDefinitionRegistry registry;

    public ClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    public void doScan(String... basePackages) {
        for (String basePackage : basePackages) {
            Set<BeanDefinition> candidates = findCandidateComponents(basePackage);
            for (BeanDefinition beanDefinition : candidates) {
                String beanScope = resolveBeanScope(beanDefinition);
                if (StrUtil.isNotEmpty(beanScope)) {
                    beanDefinition.setScope(beanScope);
                }
                registry.registerBeanDefinition(determineBeanName(beanDefinition), beanDefinition);
            }
        }
        // 注册处理注解需要的 BeanPostProcessor (@Autowired @Value
        registry.registerBeanDefinition("context.annotation.internalAutowiredAnnotationProcessor", new BeanDefinition(AutowiredAnnotationBeanPostProcessor.class));
    }


    private String resolveBeanScope(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Scope scope = beanClass.getAnnotation(Scope.class);
        if (null != scope) return scope.value();
        return StrUtil.EMPTY;
    }

    private String determineBeanName(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Component component = beanClass.getAnnotation(Component.class);
        String value = component.value();
        if (StrUtil.isEmpty(value)) {
            value = StrUtil.lowerFirst(beanClass.getSimpleName());
        }
        return value;
    }
}
