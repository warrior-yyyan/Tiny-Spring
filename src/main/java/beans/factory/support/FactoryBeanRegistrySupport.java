package beans.factory.support;

import beans.BeansException;
import beans.factory.FactoryBean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/11
 * @Copyright： yyyan.icu
 */
public abstract class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry{

    private final Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<>();

    protected Object getCachedObjectForFactoryBean(String beanName) {
        Object o = this.factoryBeanObjectCache.get(beanName);
        return o != NULL_OBJECT ? o : null;
    }

    protected Object getObjectFromFactoryBean(FactoryBean factory, String beanName) {
        if (factory.isSingleton()) {
            Object o = this.factoryBeanObjectCache.get(beanName);
            if (o == null) {
                o = doGetObjectFromFactoryBean(factory, beanName);
                this.factoryBeanObjectCache.put(beanName, o != null ? o : NULL_OBJECT);
            }
            return o != NULL_OBJECT ? o : null;
        } else {
            return doGetObjectFromFactoryBean(factory, beanName);
        }
    }

    private Object doGetObjectFromFactoryBean(final FactoryBean factory, final String beanName) {
        try {
            return factory.getObject();
        } catch (Exception e) {
            throw new BeansException("FactoryBean threw exception on object[" + beanName + "] creation", e);
        }
    }

}
