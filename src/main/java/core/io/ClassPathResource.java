package core.io;

import cn.hutool.core.lang.Assert;
import util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/4
 * @Copyright： yyyan.icu
 */
public class ClassPathResource implements Resource {

    private final String path;
    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "Path must not be null!");
        this.path = path;
        this.classLoader = classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader();
    }

    @Override
    public InputStream getInputStream() throws Exception {
        InputStream is = classLoader.getResourceAsStream(path);
        if (is == null) throw new FileNotFoundException(this.path + " cannot be opened");
        return is;
    }
}
