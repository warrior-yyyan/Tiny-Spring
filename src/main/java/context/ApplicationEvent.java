package context;

import java.util.EventObject;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/12
 * @Copyright： yyyan.icu
 */
public abstract class ApplicationEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
