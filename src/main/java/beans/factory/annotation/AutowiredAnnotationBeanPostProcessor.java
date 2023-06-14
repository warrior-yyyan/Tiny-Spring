package beans.factory.annotation;

import beans.BeansException;
import beans.PropertyValues;
import beans.factory.BeanFactory;
import beans.factory.BeanFactoryAware;
import beans.factory.ConfigurableListableBeanFactory;
import beans.factory.config.InstantiationAwareBeanPostProcessor;
import cn.hutool.core.bean.BeanUtil;
import util.ClassUtils;

import java.lang.reflect.Field;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/16
 * @Copyright： yyyan.icu
 */
public class AutowiredAnnotationBeanPostProcessor implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

    private ConfigurableListableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = ((ConfigurableListableBeanFactory) beanFactory);
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        // 处理注解 @Value
        Class<?> clazz = bean.getClass();
        clazz = ClassUtils.isCglibProxyClass(clazz) ? clazz.getSuperclass() : clazz;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            Value annotation = field.getAnnotation(Value.class);
            if (null != annotation) {
                String value = annotation.value();
                value = beanFactory.resolveEmbeddedValue(value);
                BeanUtil.setFieldValue(bean, field.getName(), value);
            }
        }

        // 处理注解 @Autowired
        for (Field field : declaredFields) {
            Autowired annotation = field.getAnnotation(Autowired.class);
            if (null != annotation) {
                Class<?> fieldType = field.getType();
                String dependentBeanName = null;
                Qualifier qualifierAnnotation = field.getAnnotation(Qualifier.class);
                Object dependentBean = null;
                if (null != qualifierAnnotation) {
                    dependentBeanName = qualifierAnnotation.value();
                    dependentBean = beanFactory.getBean(dependentBeanName, fieldType);
                } else {
                    dependentBean = beanFactory.getBean(fieldType);
                }
                BeanUtil.setFieldValue(bean, field.getName(), dependentBean);
            }
        }
        return pvs;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return true;
    }


}
