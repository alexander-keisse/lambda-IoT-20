package be.intecbrussel.opdrachten.lambda_test;

public class LambdaTest {


    public static void main(String[] args) {

        double [] firstList = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double [] secondList = {17.0, 3.14, 17.0, -3.4, 17.0, 42.0, 29.2, 3.14};

        System.out.println("Sum of the first List (should be 55): " + sum.apply(firstList));
        System.out.println("Average of the first List (should be 5.5): " + median.apply(firstList));
        System.out.println("Minimum of the second List (should be -3.4): " + min.apply(secondList));
        System.out.println("Maximum of the second List (should be 42.0): " + max.apply(secondList));

        System.out.println();

        System.out.printf("Count of 17.0 in second list (should be 3): %f %n", counter(17.0).apply(secondList));
        System.out.printf("Count of 20.0 in second list (should be 0): %f %n", counter(20.0).apply(secondList));
        System.out.printf("Count of 5.0 in second list (should be 1): %f %n", counter(5.0).apply(firstList));
    }

    public static final ArrayProcessor sum = array -> {
        double temp = 0;
        for (double v : array) {
            temp += v;
        }
        return temp;
    };

    public static final ArrayProcessor median = array -> {
        double temp = 0;
        for (double v : array) {
            temp += v;
        }
        return temp / array.length;
    };

    public static final ArrayProcessor max = array -> {
        double temp = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > temp) temp = array[i];
        }
        return temp;
    };

    public static final ArrayProcessor min = array -> {
        double temp = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < temp) temp = array[i];
        }
        return temp;
    };

    public static ArrayProcessor counter(double value) {

        return array -> {
            double temp = 0;
            for (double v : array) {
                if (v == value) temp++;
            }
            return temp;
        };
    }
}
