package core.io;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/4
 * @Copyright： yyyan.icu
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PERFIX = "classpath:";

    Resource getResource(String location);
}
