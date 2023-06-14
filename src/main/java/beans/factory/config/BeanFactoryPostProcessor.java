package beans.factory.config;

import beans.BeansException;
import beans.factory.ConfigurableListableBeanFactory;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/5
 * @Copyright： yyyan.icu
 */
public interface BeanFactoryPostProcessor {

    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
