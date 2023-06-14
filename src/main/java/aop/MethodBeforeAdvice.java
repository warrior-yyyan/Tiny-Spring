package aop;

import java.lang.reflect.Method;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/14
 * @Copyright： yyyan.icu
 */
public interface MethodBeforeAdvice extends BeforeAdvice{

    void before(Method method, Object[] args, Object target) throws Throwable;

}
