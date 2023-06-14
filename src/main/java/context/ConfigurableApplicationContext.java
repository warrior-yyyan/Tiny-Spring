package context;

import beans.BeansException;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/5
 * @Copyright： yyyan.icu
 */
public interface ConfigurableApplicationContext extends ApplicationContext{

    /**
     *  刷新容器
     * @throws BeansException
     */
    void refresh() throws BeansException;

    void registerShutdownHook();

    void close();
}
