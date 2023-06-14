package context;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/12
 * @Copyright： yyyan.icu
 */
public interface ApplicationEventPublisher {

    void publishEvent(ApplicationEvent event);

}
