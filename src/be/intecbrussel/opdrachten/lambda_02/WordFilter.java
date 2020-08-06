package be.intecbrussel.opdrachten.lambda_02;

@FunctionalInterface
public interface WordFilter {

   boolean isValid(String s);
}
