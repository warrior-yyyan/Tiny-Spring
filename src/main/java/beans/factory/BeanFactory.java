package beans.factory;


import beans.BeansException;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/1
 * @Copyright： yyyan.icu
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;

    <T> T getBean(Class<T> requiredType) throws BeansException;
}
