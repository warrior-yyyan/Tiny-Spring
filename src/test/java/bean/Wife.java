package bean;

import beans.factory.annotation.Autowired;
import stereotype.Component;

@Component
public class Wife {

    @Autowired
    private Husband husband;

    @Autowired
    private IMother mother;

    public String queryHusband() {
        return "Wife.husband、Mother.callMother：" + mother.callMother();
    }

    public Husband getHusband() {
        return husband;
    }

    public void setHusband(Husband husband) {
        this.husband = husband;
    }

    public IMother getMother() {
        return mother;
    }

    public void setMother(IMother mother) {
        this.mother = mother;
    }

}
