package beans.factory.annotation;

import java.lang.annotation.*;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/16
 * @Copyright： yyyan.icu
 */
@Documented
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Value {

    /**
     * The actual value expression: e.g. "#{systemProperties.myProp}".
     */
    String value();

}
