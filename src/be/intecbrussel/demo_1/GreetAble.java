package be.intecbrussel.demo_1;

@FunctionalInterface
public interface GreetAble {

    void greet();

    default void defaultAllowed() {
        System.out.println("No rest for the wicked!");
    }

    static void staticAllowed() {
        System.out.println("this is also ok");
    }

}
