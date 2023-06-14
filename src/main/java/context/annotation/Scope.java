package context.annotation;

import java.lang.annotation.*;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/15
 * @Copyright： yyyan.icu
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {

    String value() default "singleton";
}
