package beans.factory;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/7
 * @Copyright： yyyan.icu
 */
public interface DisposableBean {

    void destroy() throws Exception;
}
