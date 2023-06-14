package context.support;

import beans.BeansException;
import beans.factory.config.BeanPostProcessor;
import context.ApplicationContext;
import context.ApplicationContextAware;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/10
 * @Copyright： yyyan.icu
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
