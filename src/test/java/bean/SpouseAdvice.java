package bean;


import aop.MethodBeforeAdvice;
import stereotype.Component;

import java.lang.reflect.Method;

@Component
public class SpouseAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Before advice..." + method);
    }

}
