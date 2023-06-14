package context.support;

import beans.factory.support.DefaultListableBeanFactory;
import beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/5
 * @Copyright： yyyan.icu
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext{
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations) {
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
