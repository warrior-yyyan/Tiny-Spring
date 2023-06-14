package beans.factory;

import beans.BeansException;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/10
 * @Copyright： yyyan.icu
 */
public interface BeanFactoryAware extends Aware{

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;

}
