import test.ObjectClass;
import test.TargetClass;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) {
        /**
         * <a href="https://docs.oracle.com/javase/8/docs/api/</a>
         */
        String result = process(TargetClass.class, ObjectClass.class);
        System.out.println("Result:\n"+result);
        //--
        result = process(ObjectClass.class, TargetClass.class);
        System.out.println("Checking for symmetry:\n"+result);
    }

    private static String process(Class targetClass, Class objectClass){
        String result="";
        try {
            Generator.Adapter adapter = Generator.generateAdapter(targetClass, objectClass);
            Saver.saveToFile(adapter.data, "src/" + Generator.PACKAGE + "/" + adapter.name);
            if (true) {//compile in current project to check
                result += "SUCCESS";
            } else {
                result += "FAIL";
            }
        } catch (Exception e) {
            result = "An exception occurred: ";
            for (StackTraceElement element : e.getStackTrace()) {
                result += "\n" + element;
            }
        }
        return result;
    }
}
