package be.intecbrussel.opdrachten.lambda_01;

@FunctionalInterface
public interface WordFilter {

   boolean isValid(String s);
}
