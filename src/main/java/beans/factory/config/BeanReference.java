package beans.factory.config;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/3
 * @Copyright： yyyan.icu
 */
public class BeanReference {

    private final String beanName;

    public String getBeanName() {
        return beanName;
    }

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }
}
