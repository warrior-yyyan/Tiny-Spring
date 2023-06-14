package beans.factory.config;

import beans.BeansException;
import beans.factory.BeanFactory;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/4
 * @Copyright： yyyan.icu
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    /**
     *  执行BeanPostProcessors 接口实现类的 postProcessBeforeInitialization 方法
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    /**
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;
}
