package Task4;

import java.io.File;
import java.lang.reflect.Method;
import java.util.List;

public class ClassForAnnotationInit {

    public static void main(String[] args) throws ClassNotFoundException {
        String path = "src/main/java/Task4";
        File file = new File(path);
        List<File> files = MainClass.takeJavaClasses(file);
        findAnnotation(files);
    }

    public static void findAnnotation(List<File> files) throws ClassNotFoundException {
        for (int i = 0; i < files.size(); i++) {
            Class<?> ourClass = Class.forName(MainClass.returnPathForMethodForName(files.get(i)));

            Method[] methods = ourClass.getDeclaredMethods();

            for (Method method :
                    methods) {
                if(method.isAnnotationPresent(Init.class)) {
                    System.out.println(method);
                }
            }
        }
    }
}
