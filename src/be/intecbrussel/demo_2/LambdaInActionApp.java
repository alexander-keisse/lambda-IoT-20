package be.intecbrussel.demo_2;

// More info: https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#syntax

public class LambdaInActionApp {

    @FunctionalInterface
    interface FuncInter1 {
        int operation(int a, int b);
    }

    @FunctionalInterface
    interface FuncInter2 {
        void sayMessage(String s);
    }

    private static int operate(int number1, int number2, FuncInter1 fobj) {

        return fobj.operation(number1, number2);
    }

    public static void main(String[] args) {

        FuncInter1 add = (int x, int y) -> x + y;

        System.out.println("Addition is: " + operate(6,3, add));
        System.out.println("Multiplication is: " + operate(6, 3, (x, y) -> x * y));

        FuncInter2 fobj = msg -> System.out.println("Hello, " + msg);
        fobj.sayMessage("Alex");
    }

}
