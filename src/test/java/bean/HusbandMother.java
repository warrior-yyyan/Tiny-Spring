package bean;


import beans.factory.FactoryBean;
import stereotype.Component;

import java.lang.reflect.Proxy;

/**
 * 代理类
 */
public class HusbandMother implements FactoryBean<IMother> {

    @Override
    public IMother getObject() throws Exception {
        return (IMother) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{IMother.class},
                (proxy, method, args) -> "wife's mother -> husband's mother" + method.getName());
    }

    @Override
    public Class<IMother> getObjectType() {
        return IMother.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

}
