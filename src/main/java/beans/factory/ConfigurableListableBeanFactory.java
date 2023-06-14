package beans.factory;

import beans.BeansException;
import beans.factory.config.AutowireCapableBeanFactory;
import beans.factory.config.BeanDefinition;
import beans.factory.config.BeanPostProcessor;
import beans.factory.config.ConfigurableBeanFactory;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/4
 * @Copyright： yyyan.icu
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}
