package context.event;

import beans.factory.BeanFactory;
import context.ApplicationEvent;
import context.ApplicationListener;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/12
 * @Copyright： yyyan.icu
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster{

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
