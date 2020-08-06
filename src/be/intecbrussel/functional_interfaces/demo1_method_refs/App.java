package be.intecbrussel.functional_interfaces.demo1_method_refs;

import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {

        // Static method reference

        List<Integer> numbers = Arrays.asList(1, 2784, 3, 469, 5, 1476, 4578, 18, -22, 10);

        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }

        System.out.println();  // newline

        for (int e: numbers) {
            System.out.println(e);
        }

        System.out.println();  // newline

        numbers.forEach(System.out::println);  // HERE

        System.out.println();  // newline

        // Instance method reference

        FaultySoftware bugSoftware = new FaultySoftware();
        numbers.forEach(bugSoftware::printAllNumbers);  // HERE

        // Constructor reference

        String hello = "hello";

        Scrambler scrambler = new Scrambler(hello, 42);
        scrambler.scramble(Integer::new);  // HERE

        System.out.println(
                Arrays.toString(
                        scrambler.getScrambled()));

    }

}
