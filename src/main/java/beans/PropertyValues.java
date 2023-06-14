package beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author：yyyan
 * @date: 2023/3/3
 * @Copyright： yyyan.icu
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv) {
        this.propertyValueList.add(pv);
    }

    public PropertyValue[] getProperValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String name) {
        for (PropertyValue pv : propertyValueList) {
            if (pv.getName().equals(name)) {
                return pv;
            }
        }
        return null;
    }
}
