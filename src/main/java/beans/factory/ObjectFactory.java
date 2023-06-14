package beans.factory;

import beans.BeansException;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/20
 * @Copyright： yyyan.icu
 */
public interface ObjectFactory<T> {

    T getObject() throws BeansException;
}
