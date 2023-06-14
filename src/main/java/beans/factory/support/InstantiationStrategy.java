package beans.factory.support;

import beans.BeansException;
import beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/2
 * @Copyright： yyyan.icu
 */
public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;
}
