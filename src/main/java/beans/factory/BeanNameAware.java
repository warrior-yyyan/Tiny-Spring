package beans.factory;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/10
 * @Copyright： yyyan.icu
 */
public interface BeanNameAware extends Aware {

    void setBeanName(String name);

}

