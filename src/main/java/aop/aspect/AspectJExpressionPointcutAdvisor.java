package aop.aspect;

import aop.Pointcut;
import aop.PointcutAdvisor;
import beans.factory.annotation.Autowired;
import beans.factory.annotation.Value;
import org.aopalliance.aop.Advice;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/14
 * @Copyright： yyyan.icu
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    // 切面
    @Autowired
    private AspectJExpressionPointcut pointcut;

    // 具体的拦截方法
    @Autowired
    private Advice advice;

    // 表达式
    @Value("${expression}")
    private String expression;

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    @Override
    public Pointcut getPointcut() {
        if (null == pointcut) {
            return new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }
}
