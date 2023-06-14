package aop;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/14
 * @Copyright： yyyan.icu
 */
public interface PointcutAdvisor extends Advisor{

    Pointcut getPointcut();
}
