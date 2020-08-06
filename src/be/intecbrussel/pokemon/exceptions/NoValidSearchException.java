package be.intecbrussel.pokemon.exceptions;

import java.util.InputMismatchException;

public class NoValidSearchException extends InputMismatchException {

    public NoValidSearchException() { super(); }

    public NoValidSearchException(String s) {
        super(s);
    }

}
