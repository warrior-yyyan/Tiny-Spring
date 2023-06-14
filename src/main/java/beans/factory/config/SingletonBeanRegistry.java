package beans.factory.config;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/1
 * @Copyright： yyyan.icu
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

    void registerSingleton(String beanName, Object singletonObject);
}
