package Task4;

import Task2.Value;
import Task3.Service;

@Service
public class TestClassWithServiceOne {
    @Value(value = "field1")
    private String field1;
    @Value(value = "field2")
    private String field2;
    @Value()
    private String field3;

    @Init
    public static void publicMethodInTestClassWithServiceOne() {
    }

    @Init
    private static void privateMethodInTestClassWithServiceOne() {
    }

    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }

    public String getField3() {
        return field3;
    }
}
