package beans.factory.config;

import beans.BeansException;
import beans.PropertyValues;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/14
 * @Copyright： yyyan.icu
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {


    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;

    boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException;

    PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException;

    default Object getEarlyBeanReference(Object bean, String beanName) {
        return bean;
    }

}
