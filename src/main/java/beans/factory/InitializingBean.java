package beans.factory;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/7
 * @Copyright： yyyan.icu
 */
public interface InitializingBean {

    /**
     *  Bean 处理属性填充后调用
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;
}
