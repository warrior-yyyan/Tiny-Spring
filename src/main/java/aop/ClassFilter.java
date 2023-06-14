package aop;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/13
 * @Copyright： yyyan.icu
 */
public interface ClassFilter {

    boolean matches(Class<?> clazz);

}
