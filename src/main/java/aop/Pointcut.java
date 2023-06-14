package aop;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/13
 * @Copyright： yyyan.icu
 */
public interface Pointcut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();

}
