package be.intecbrussel.opdrachten.lambda_02;

public class TextScrambler {
   
   public String scramble(String s) {

      return s.replace("a","@")
              .replace("e","€")
              .replace("l","1")
              .replace("o","0");
   }
}
