package Task1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class AChange {

    public static void main(String[] args) {
        try {
            Constructor<?> aConstructor = A.class.getDeclaredConstructor();
            aConstructor.setAccessible(true);
            A a = (A) aConstructor.newInstance();
            Field idField = A.class.getDeclaredField("id");
            Field nameField = A.class.getDeclaredField("name");
            idField.setAccessible(true);
            nameField.setAccessible(true);
            idField.set(a, "New id");
            nameField.set(a, "New name");
            System.out.println(a);
        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }

    }
}
