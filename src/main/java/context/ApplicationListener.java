package context;

import java.util.EventListener;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/12
 * @Copyright： yyyan.icu
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    void onApplicationEvent(E event);
}
