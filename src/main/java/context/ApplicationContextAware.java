package context;

import beans.BeansException;
import beans.factory.Aware;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/10
 * @Copyright： yyyan.icu
 */
public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
