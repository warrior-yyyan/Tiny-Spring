package beans.factory;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/11
 * @Copyright： yyyan.icu
 */
public interface FactoryBean<T>{

    T getObject() throws Exception;

    Class<T> getObjectType();

    boolean isSingleton();
}
