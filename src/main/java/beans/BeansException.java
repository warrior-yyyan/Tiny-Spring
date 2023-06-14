package beans;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/1
 * @Copyright： yyyan.icu
 */
public class BeansException extends RuntimeException{

    public BeansException(String msg) {super(msg);}

    public BeansException(String msg, Throwable cause) {super(msg, cause);}
}
