package bean;

import beans.factory.annotation.Autowired;
import beans.factory.annotation.Value;
import stereotype.Component;

@Component
public class Husband {

    @Value("${work}")
    private String work;

    @Autowired
    private Wife wife;

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String queryWife(){
        return "Husband.wife";
    }

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }

}
