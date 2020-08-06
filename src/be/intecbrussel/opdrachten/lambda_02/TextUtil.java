package be.intecbrussel.opdrachten.lambda_02;

public interface TextUtil {
   
   static String quote(String s) {

      return String.format("<<%s>>",s);
   }
      
   static String reverse(String s) {

      return new StringBuilder(s).reverse().toString();
   }   
}
