package be.intecbrussel.functional_interfaces.demo2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class AfterHoursOfShame {

    private static int totalValue(List<Integer> numbers, Predicate<Integer> selector) {
        int total = 0;

        for (int e: numbers) {
            if (selector.test(e)) total += e;
        }

        return total;
    }

    private static int streamlinedTotalValue(List<Integer> values, Predicate<Integer> selector) {
        return values.stream()
                .filter(selector)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(totalValue(numbers, e -> true));
        System.out.println(totalValue(numbers, e -> e % 2 == 0));
        System.out.println(totalValue(numbers, e -> e % 2 != 0));

        Predicate<Integer> condition1 = e -> e % 2 == 0;
        Predicate<Integer> condition2 = e -> e != 4;

        Predicate<Integer> bothConditions = condition1.and(condition2);

        System.out.println(totalValue(numbers, bothConditions));

    }

}
