package Task4;

import Task2.Value;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class ClassForAnnotationValue {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException {
        TestClassWithServiceOne testClassWithServiceOne = new TestClassWithServiceOne();
        findAnnotation(testClassWithServiceOne);
        System.out.println(testClassWithServiceOne.getField1());
        System.out.println(testClassWithServiceOne.getField2());
        System.out.println(testClassWithServiceOne.getField3());
    }

    public static <T> void findAnnotation(T nameOfClass) throws ClassNotFoundException, IllegalAccessException {
            Field[] fields = nameOfClass.getClass().getDeclaredFields();
            for (Field field :
                    fields) {
                field.setAccessible(true);
                if(field.isAnnotationPresent(Value.class)) {
                    Value annotation = field.getAnnotation(Value.class);
                    String value = annotation.value();
                    field.set(nameOfClass, value);
                    field.setAccessible(false);
                }
            }
    }
}
