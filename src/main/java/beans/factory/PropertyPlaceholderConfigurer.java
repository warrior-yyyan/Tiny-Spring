package beans.factory;

import beans.BeansException;
import beans.PropertyValue;
import beans.PropertyValues;
import beans.factory.annotation.Value;
import beans.factory.config.BeanDefinition;
import beans.factory.config.BeanFactoryPostProcessor;
import core.io.DefaultResourceLoader;
import core.io.Resource;
import stereotype.Component;
import util.StringValueResolver;

import java.util.Properties;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/15
 * @Copyright： yyyan.icu
 */

/**
 * 通过xml或注解的方式注入, 解析.properties文件内容并将字符串解析器缓存到beanFactory
 */
public class PropertyPlaceholderConfigurer implements BeanFactoryPostProcessor {

    public static final String DEFAULT_PLACEHOLDER_PREFIX = "${";
    public static final String DEFAULT_PLACEHOLDER_SUFFIX = "}";

    private String location;

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // 加载属性文件
        try {
            DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
            Resource resource = resourceLoader.getResource(location);
            Properties properties = new Properties();
            properties.load(resource.getInputStream());

            String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
            for (String beanName : beanDefinitionNames) {
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
                PropertyValues propertyValues = beanDefinition.getPropertyValues();
                for (PropertyValue propertyValue : propertyValues.getProperValues()) {
                    Object value = propertyValue.getValue();
                    if (!(value instanceof String)) continue;
                    value = resolvePlaceholder((String) value, properties);
                    propertyValues.addPropertyValue(new PropertyValue(propertyValue.getName(), value));
                }
            }
            // 向容器中添加字符串解析器，供解析@Value注解使用
            PlaceHolderResolvingStringValueResolver valueResolver = new PlaceHolderResolvingStringValueResolver(properties);
            beanFactory.addEmbeddedValueResolver(valueResolver);

        } catch (Exception e) {
            throw new BeansException("Could not load properties", e);
        }
    }

    private String resolvePlaceholder(String value, Properties properties) {
        String strVal = value;
        StringBuilder buffer = new StringBuilder(strVal);
        int startIdx = strVal.indexOf(DEFAULT_PLACEHOLDER_PREFIX);
        int stopIdx = strVal.indexOf(DEFAULT_PLACEHOLDER_SUFFIX);
        if (startIdx != -1 && stopIdx != -1 && startIdx < stopIdx) {
            String propKey = strVal.substring(startIdx + 2, stopIdx);
            String propVal = properties.getProperty(propKey);
            buffer.replace(startIdx, stopIdx + 1, propVal);
        }
        return buffer.toString();
    }

    private class PlaceHolderResolvingStringValueResolver implements StringValueResolver {

        private final Properties properties;

        public PlaceHolderResolvingStringValueResolver(Properties properties) {
            this.properties = properties;
        }

        @Override
        public String resolveStringValue(String strVal) {
            return PropertyPlaceholderConfigurer.this.resolvePlaceholder(strVal, properties);
        }
    }
}
