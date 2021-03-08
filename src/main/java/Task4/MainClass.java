package Task4;

import Task3.Service;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class MainClass {
    public static void main(String[] args) {
        String path = "src/main/java/Task4";
        File file = new File(path);
        System.out.println(mapWithObjectWhichHaveAnnotationService(takeJavaClasses(file)));
    }

    public static List<File> takeJavaClasses(File file) {
        List<File> filesInFile = new LinkedList<>(Arrays.asList(Objects.requireNonNull(file.listFiles())));
        List<File> returnedListOfFiles = new LinkedList<>();
        for (int i = 0; i < filesInFile.size(); i++) {
            if (filesInFile.get(i).getName().contains(".java")) {
                returnedListOfFiles.add(filesInFile.get(i));
            }
        }
        return returnedListOfFiles;
    }

    public static Map<String, Object> mapWithObjectWhichHaveAnnotationService(List<File> files) {
        Map<String, Object> finalMap = new LinkedHashMap<>();

        for (int i = 0; i < files.size(); i++) {
            try {
                String stringPathForClass = returnPathForMethodForName(files.get(i));
                Class<?> ourClass = Class.forName(stringPathForClass);

                returnPathForMethodForName(files.get(i));

                if (ourClass.isAnnotationPresent(Service.class)) {
                    try {
                        Constructor<?> ourConstructor = ourClass.getConstructor();
                        Object entity = ourConstructor.newInstance();
                        finalMap.put(files.get(i).getName().substring(0, files.get(i).getName().length() - 5), entity);
                    } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return finalMap;
    }

    public static String returnPathForMethodForName(File file) {
        String filePathString = file.getPath().replace("\\", ".");
        return filePathString.substring(14, filePathString.length() - 5);
    }
}
