package context.support;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/5
 * @Copyright： yyyan.icu
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext{

    private String[] configLocations;

    public ClassPathXmlApplicationContext() {}

    /**
     *  从XML 中加载BeanDefinition 并刷新上下文
     * @param configLocations
     */
    public ClassPathXmlApplicationContext(String configLocations) {
        this(new String[]{configLocations});
    }

    /**
     *  从XML 中加载BeanDefinition 并刷新上下文
     * @param configLocations
     */
    public ClassPathXmlApplicationContext(String[] configLocations) {
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }
}
