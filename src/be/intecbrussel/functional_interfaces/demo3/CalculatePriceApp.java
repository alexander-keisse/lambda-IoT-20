package be.intecbrussel.functional_interfaces.demo3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class CalculatePriceApp {

    public static void main(String[] args) {

        List<Double> productPrice = Arrays.asList(244.99, 14.95, 54.99,
                69.99, 44.5, 418.2);

        List<Double> temp = new ArrayList<>();

        Function<Double, Double> originalPrice = x -> x;
        Function<Double, Double> discountPrice = x -> x = x - (x/10);

        Consumer<Double> consumer = System.out::println;
        Consumer<Double> consumerList = temp::add;

        calculateProductPrice(productPrice, originalPrice, consumer);
        calculateProductPrice(productPrice, discountPrice, consumer);

        Function<Double, Integer> crazyPrices = Double::intValue;

//        calculateProductPrice(productPrice, crazyPrices); // Remove <Double, Double> in method to work.

        Function<Double, Double> summerSalePrice = x -> x *= 1.2;
        calculateProductPrice(productPrice, summerSalePrice.andThen(discountPrice), consumerList);

        System.out.println("\nPRINTOUT TEMP");
        temp.forEach(System.out::println);
    }

    private static void calculateProductPrice(List<Double> productPrices,
                                              Function<Double, Double> action,
                                              Consumer<Double> consumer) {
        productPrices.stream()
                .map(action)
                .forEach(consumer);
        System.out.println();
    }

}
