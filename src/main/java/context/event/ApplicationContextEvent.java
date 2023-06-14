package context.event;

import context.ApplicationContext;
import context.ApplicationEvent;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/12
 * @Copyright： yyyan.icu
 */
public class ApplicationContextEvent extends ApplicationEvent {

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext() {
        return ((ApplicationContext) getSource());
    }
}
