package stereotype;

import java.lang.annotation.*;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/15
 * @Copyright： yyyan.icu
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {

    String value() default "";

}
