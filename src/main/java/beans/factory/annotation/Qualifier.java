package beans.factory.annotation;

import java.lang.annotation.*;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/16
 * @Copyright： yyyan.icu
 */
@Documented
@Inherited
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Qualifier {

    String value() default "";
}
