package be.intecbrussel.demo_3;

public class App {

    public static void main(String[] args) {

        // String s = "Hello there";  // Bad
        FuncInterface fun = (String s) -> System.out.println(s);

        String s = "Hello there";  // Good
        fun.functionality(s);

        s = "something different";

        FuncInterface anonFun = new FuncInterface() {

            // Own scope

            String s = "I'm always overlooked :( ";

            @Override
            public void functionality(String s) {
                s = this.s;
                System.out.println(s);
            }
        };

        anonFun.functionality(s);

//        fun = d -> System.out.println(s); // this is bad mkay...
    }

}
