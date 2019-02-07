import test.ObjectClass;
import test.TargetClass;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) {
        Generator.Adapter adapter = Generator.generateAdapter(TargetClass.class, ObjectClass.class);
        String result = "Result is ";
        try {
            Saver.saveToFile(adapter.data, "src/" + Generator.PACKAGE + "/" + adapter.name);
            if (true) {//compile in current project to check
                result += "valid";
            } else {
                result += "invalid";
            }
        } catch (IOException e) {
            result = "An exception occurred: ";
            for (StackTraceElement element : e.getStackTrace()) {
                result += "\n" + element;
            }
        }
        System.out.println(result);
    }
}
