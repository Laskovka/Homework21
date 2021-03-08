package Task4;

import Task3.Service;

@Service
public class TestClassWithServiceTwo {
    @Init
    public static void publicMethodInTestClassWithServiceTwo() {
    }

    @Init
    private static void privateMethodInTestClassWithServiceTwo() {
    }
}
