package beans.factory.support;


import beans.BeansException;
import beans.factory.DisposableBean;
import beans.factory.ObjectFactory;
import beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/1
 * @Copyright： yyyan.icu
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    protected static final Object NULL_OBJECT = new Object();

    // 一级缓存，完整的bean对象
    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>();

    // 二级缓存
    protected final Map<String, Object> earlySingletonObjects = new HashMap<>();

    // 三级缓存
    private final Map<String, ObjectFactory<?>> singletonFactories = new HashMap<>();

    private final Map<String, DisposableBean> disposableBeans = new LinkedHashMap<>();

    /**
     * 一级缓存对应存取
     */
    @Override
    public Object getSingleton(String beanName) {
        Object singletonObject = singletonObjects.get(beanName);
        if (null == singletonObject) {
            singletonObject = earlySingletonObjects.get(beanName);

            // 从二级缓存拿不到就去拿对应的工厂对象，用工厂产生代理对象，并存入二级缓存
            if (null == singletonObject) {
                ObjectFactory<?> singletonFactory = singletonFactories.get(beanName);
                if (singletonFactory != null) {
                    singletonObject = singletonFactory.getObject();
                    // 把三级缓存中的代理对象中的真实对象获取出来，放入二级缓存中
                    earlySingletonObjects.put(beanName, singletonObject);
                    singletonFactories.remove(beanName);
                }
            }
        }
        return singletonObject;
    }

    /**
     * 二级缓存对应存取
     * 将成品对象放入一级缓存，并清除对应的二三级缓存中的对象
     */
    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
        earlySingletonObjects.remove(beanName);
        singletonFactories.remove(beanName);
    }

    /**
     * 三级缓存对应存取
     */
    protected void addSingletonFactory(String beanName, ObjectFactory<?> singletonFactory){
        if (!this.singletonObjects.containsKey(beanName)) {
            this.singletonFactories.put(beanName, singletonFactory);
            this.earlySingletonObjects.remove(beanName);
        }
    }

    public void registerDisposableBean(String beanName, DisposableBean bean) {
        disposableBeans.put(beanName, bean);
    }


    public void destroySingletons() {
        Set<String> keySet = this.disposableBeans.keySet();
        Object[] disposableBeanNames = keySet.toArray();
        for (int i = disposableBeanNames.length - 1; i >= 0; -- i) {
            Object beanName = disposableBeanNames[i];
            DisposableBean disposableBean = disposableBeans.remove(beanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + beanName + "' threw an exception", e);
            }

        }
    }
}
