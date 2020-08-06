package be.intecbrussel.opdrachten.lambda_01;

public class TextPrinter {

   private final String sentence;

   public TextPrinter(String sentence) {
      this.sentence = sentence;
   }

   public void printFilteredWords(WordFilter filter) {
      for (String w : sentence.split(" ")) {
         if (filter.isValid(w)) {
            System.out.println(w);
         }
      }
   }
   
   public String toString() {
      return sentence;
   }
}
