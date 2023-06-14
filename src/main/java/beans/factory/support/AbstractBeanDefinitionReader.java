package beans.factory.support;

import core.io.DefaultResourceLoader;
import core.io.ResourceLoader;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/4
 * @Copyright： yyyan.icu
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{
    private final BeanDefinitionRegistry registry;
    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
