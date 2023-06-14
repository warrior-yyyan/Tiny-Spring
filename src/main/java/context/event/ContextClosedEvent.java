package context.event;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/12
 * @Copyright： yyyan.icu
 */
public class ContextClosedEvent extends ApplicationContextEvent{
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextClosedEvent(Object source) {
        super(source);
    }
}
