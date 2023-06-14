package core.io;

import java.io.InputStream;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/4
 * @Copyright： yyyan.icu
 */
public interface Resource {

    InputStream getInputStream() throws Exception;
}
