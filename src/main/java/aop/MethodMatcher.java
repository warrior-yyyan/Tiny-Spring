package aop;

import java.lang.reflect.Method;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/13
 * @Copyright： yyyan.icu
 */
public interface MethodMatcher {

    boolean matches(Method method, Class<?> targetClass);

}
