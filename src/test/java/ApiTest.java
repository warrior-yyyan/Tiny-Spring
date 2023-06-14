import bean.Husband;
import bean.Wife;
import context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/20
 * @Copyright： yyyan.icu
 */
public class ApiTest {

    @Test
    public void test_xml() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        Husband husband = applicationContext.getBean("husband", Husband.class);
        Wife wife = applicationContext.getBean("wife", Wife.class);
        System.out.println(husband.getWork());
        System.out.println(husband.queryWife());
        System.out.println(wife.queryHusband());
    }

}
