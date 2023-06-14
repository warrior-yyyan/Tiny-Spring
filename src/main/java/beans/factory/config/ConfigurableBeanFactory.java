package beans.factory.config;

import beans.factory.HierarchicalBeanFactory;
import util.StringValueResolver;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/4
 * @Copyright： yyyan.icu
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    /**
     * 销毁单例对象
     */
    void destroySingletons();

    void addEmbeddedValueResolver(StringValueResolver valueResolver);

    String resolveEmbeddedValue(String value);

}
