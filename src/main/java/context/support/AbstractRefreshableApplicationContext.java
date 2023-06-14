package context.support;

import beans.BeansException;
import beans.factory.ConfigurableListableBeanFactory;
import beans.factory.support.DefaultListableBeanFactory;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/5
 * @Copyright： yyyan.icu
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext{

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return this.beanFactory;
    }
}
