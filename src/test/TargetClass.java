package test;

import java.util.ArrayList;
import java.util.List;

public class TargetClass {
    private String name;
    private List values;

    public TargetClass(){
        values = new ArrayList();
    }

    public String getName() {
        return name;
    }

    public List getValues() {
        return values;
    }

    public void addValue(ValueTargetClass value){
        values.add(value);
    }

    public void removeValue(){}

    boolean isRestricted(){
        return true;
    }
}
