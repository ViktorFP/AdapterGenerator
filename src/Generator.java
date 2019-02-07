import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class Generator {
    public static final String PACKAGE = "results";

    public static Adapter generateAdapter(Class targetClass, Class objectClass) {
        StringBuilder sb = new StringBuilder();
        //--package
        sb.append("package " + PACKAGE + ";\n\n");
        //--
        String adapterName = objectClass.getSimpleName() + "Adapter";
        String objectClassMemberName = getObjectClassMemberName(objectClass);
        sb.append("/***/\n");
        sb.append("public ");
        sb.append("class");
        sb.append(" " + adapterName + " extends ");
        sb.append(targetClass.getName());
        sb.append(" {\n");
        //--member
        sb.append("\n /***/\n");
        sb.append(" private ");
        sb.append(objectClass.getName() + " ");
        sb.append(objectClassMemberName);
        sb.append(";\n");
        //--constructor
        sb.append("\n /***/\n");
        sb.append(" public ");
        sb.append(adapterName);
        sb.append("(");
        sb.append(objectClass.getName());
        sb.append(" obj");
        sb.append(")\n {\n");
        sb.append("  " + objectClassMemberName + " = obj;\n");
        sb.append(" }");
        //--
        addMethods(targetClass, objectClassMemberName, sb);
        sb.append("\n\n}");
        return new Adapter(adapterName, sb.toString());
    }

    private static String getObjectClassMemberName(Class objectClass) {
        String name = objectClass.getSimpleName();
        return "m_" + Character.toLowerCase(name.charAt(0)) + objectClass.getSimpleName().substring(1);
    }

    private static void addMethods(Class targetClass, String objectClassMemberName, StringBuilder sb) {
        Method[] methods = targetClass.getMethods();
        for (Method method : methods) {
            if (!Modifier.isFinal(method.getModifiers())) {
                //todo @param ...
                //todo lists (check type by add())
                // and Objects: from type1 to type2
                sb.append("\n\n /***/\n");
                sb.append(" public ");
                if (method.getModifiers() == Modifier.STATIC) {
                    sb.append("static ");
                }
                //--
                Class returnType = method.getReturnType();
                sb.append(returnType.getName() + " ");
                //--parameters
                String parameters = "";
                String arguments = "";
                for (Parameter parameter : method.getParameters()) {
                    arguments += parameter.getType().getName() + " " + parameter.getName() + ", ";
                    parameters += parameter.getName() + ", ";
                }
                if (!parameters.isEmpty()) {
                    parameters = parameters.substring(0, parameters.length() - 2);
                    arguments = arguments.substring(0, arguments.length() - 2);
                }
                //--
                sb.append(method.getName() + "(");
                sb.append(arguments);
                sb.append(")\n");
                sb.append(" {");
                if (returnType != Void.TYPE) {
                    sb.append("\n  return " + objectClassMemberName + "." + method.getName() + "(" + parameters + ");");
                }
                sb.append("\n }");

            }
        }
    }

    public static class Adapter {
        public final String name;
        public final String data;

        public Adapter(String name, String data) {
            this.name = name + ".java";
            this.data = data;
        }
    }
}
