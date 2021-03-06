package be.intecbrussel.opdrachten.lambda_03;

import java.util.function.Function;
import java.util.function.Predicate;

public class TextApp {

   public static void main(String[] args) {

      TextPrinter tp = new TextPrinter(
            "Hello this is an example of a sentence containing words",System.out::println);
      
      System.out.println("*** Words containing 'e' ***");
      Predicate<String> pred1 = s -> s.contains("e");
      tp.printFilteredWords(pred1);

      System.out.println("*** Words containing 'a' ***");
      Predicate<String> pred2 = s -> s.contains("a");
      tp.printFilteredWords(pred2);

      System.out.println("*** Words containing 'e' and 'a' ***");
      Predicate<String> pred3 = pred1.and(pred2);
      
      tp.printFilteredWords(pred3);

		Function<String, String> proc1 = String::toUpperCase;
		Function<String, String> proc2 = TextUtil::reverse;
		Function<String, String> proc3 = proc2.andThen(proc1);

		tp.printProcessedWords(proc3);
   }
}
