package beans.factory.support;


import beans.BeansException;
import beans.factory.FactoryBean;
import beans.factory.config.BeanDefinition;
import beans.factory.config.BeanPostProcessor;
import beans.factory.config.ConfigurableBeanFactory;
import util.ClassUtils;
import util.StringValueResolver;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/1
 * @Copyright： yyyan.icu
 */
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {

    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    private final List<StringValueResolver> embeddedValueResolvers = new ArrayList<>();

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    protected <T> T doGetBean(final String name, final Object[] args) throws BeansException {
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) getObjectForBeanInstance(bean, name);
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        Object o = createBean(name, beanDefinition, args);
        return (T) getObjectForBeanInstance(o, name);
    }

    private Object getObjectForBeanInstance(Object beanInstance, String beanName) {
        if (!(beanInstance instanceof FactoryBean)) {
            return beanInstance;
        }

        Object o = getCachedObjectForFactoryBean(beanName);

        if (o == null) {
            FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance;
            o = getObjectFromFactoryBean(factoryBean, beanName);
        }
        return o;
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    @Override
    public void addEmbeddedValueResolver(StringValueResolver valueResolver) {
        this.embeddedValueResolvers.add(valueResolver);
    }

    @Override
    public String resolveEmbeddedValue(String value) {
        String result = value;
        for (StringValueResolver resolver : this.embeddedValueResolvers) {
            result = resolver.resolveStringValue(result);
        }
        return result;
    }

    /**
     * Return the list of BeanPostProcessors that will get applied
     * to beans created with this factory.
     */
    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }

    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader;
    }

}
