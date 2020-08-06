package be.intecbrussel.functional_interfaces.demo2;

import java.util.Arrays;
import java.util.List;

public class DuplicateBadCode {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(totalValue(numbers));
        System.out.println(totalEvenValue(numbers));

    }

    private static int totalValue(List<Integer> numbers) {
        int total = 0;

        for (Integer number : numbers) {
            total += number;
        }

        return total;

    }

    private static int totalEvenValue(List<Integer> numbers) {
        int total = 0;

        for (Integer number : numbers) {
            if (number % 2 == 0) total += number;
        }

        return total;

    }

    private static int totalOddValue(List<Integer> numbers) {
        int total = 0;

        for (Integer number : numbers) {
            if (number % 2 != 0) total += number;
        }

        return total;

    }

}
