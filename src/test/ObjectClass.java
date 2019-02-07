package test;

import java.util.ArrayList;
import java.util.List;

public class ObjectClass {
    private String name;
    private List values;

    public ObjectClass(){
        values = new ArrayList();
    }

    public String getName() {
        return name;
    }

    public List getValues() {
        return values;
    }

    public void addValue(ValueObjectClass value){
        values.add(value);
    }
}
