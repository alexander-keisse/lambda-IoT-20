package be.intecbrussel.demo_1;

public class App {

    public static void main(String[] args) {

        // 1.a

        GreetAble implObject = new GreetAble() {
            @Override
            public void greet() {
                System.out.println("This is quite cumbersome!");
            }
        };

        implObject.greet();

        implObject.defaultAllowed();
        GreetAble.staticAllowed();

        implObject = new GreetAble() {
            @Override
            public void greet() {
                System.out.println("We made a new implementation.");
            }
        };

        implObject.greet();

        // 1.B

        GreetAble lobj = () -> System.out.println("Js makes me want to flip the table and say" +
                "'Screw this', but I can never be sure what 'this' refers to");

        lobj.greet();

        int a = 5;

        Calculator calculator = (int x) -> x * x;
        System.out.println("Multiplication: " + calculator.calculate(a));

        calculator = x -> x + x;
        System.out.println("Addition: " + calculator.calculate(a));


    }
}
