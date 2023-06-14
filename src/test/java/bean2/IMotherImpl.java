package bean2;

import stereotype.Component;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/6/14
 * @Copyright： yyyan.icu
 */
@Component
public class IMotherImpl implements IMother{
    @Override
    public String callMother() {
        return "call mother...";
    }
}
