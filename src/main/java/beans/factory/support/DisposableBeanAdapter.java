package beans.factory.support;

import beans.BeansException;
import beans.factory.DisposableBean;
import beans.factory.config.BeanDefinition;
import cn.hutool.core.util.StrUtil;

import java.lang.reflect.Method;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/7
 * @Copyright： yyyan.icu
 */
public class DisposableBeanAdapter implements DisposableBean {
    private final Object bean;
    private final String beanName;
    private String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        // 1. 实现接口 DisposableBean
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }
        
        // 2. 注解配置 destroy-method (避免二次执行销毁)
        if (StrUtil.isNotEmpty(destroyMethodName) && !(bean instanceof DisposableBean && "destroy".equals(this.destroyMethodName))) {
            Method destroyMethod = bean.getClass().getMethod(destroyMethodName);
            if (null == destroyMethod) throw new BeansException("Couldn't find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");
            destroyMethod.invoke(bean);
        }

    }
}
