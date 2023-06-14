import bean2.Husband;
import bean2.Wife;
import context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/20
 * @Copyright： yyyan.icu
 */
public class ApiTest2 {

    @Test
    public void test_annotation() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-scan.xml");
        Husband husband = applicationContext.getBean("husband", Husband.class);
        Wife wife = applicationContext.getBean("wife", Wife.class);
        System.out.println(husband.getWork());
        System.out.println(husband.queryWife());
        System.out.println(wife.queryHusband());
    }
}
