package context;

import beans.factory.HierarchicalBeanFactory;
import beans.factory.ListableBeanFactory;
import core.io.ResourceLoader;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/5
 * @Copyright： yyyan.icu
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
}
