package beans.factory.config;

import beans.BeansException;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/5
 * @Copyright： yyyan.icu
 */
public interface BeanPostProcessor {

    /**
     *  在Bean对象执行初始化方法之前，执行此方法
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     *  初始化之后执行
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
