package Task4;

public class TestClassWithoutServiceOne {
    @Init
    public static void publicMethodInTestClassWithoutServiceOne() {
    }

    @Init
    private static void privateMethodInTestClassWithoutServiceOne() {
    }

    private static void someMethod() {
        System.out.println("Never");
    }
}
