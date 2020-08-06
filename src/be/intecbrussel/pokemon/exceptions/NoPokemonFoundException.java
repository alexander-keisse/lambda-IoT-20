package be.intecbrussel.pokemon.exceptions;

public class NoPokemonFoundException extends NullPointerException {

    public NoPokemonFoundException() {
        super();
    }

    public NoPokemonFoundException(String s) {
        super(s);
    }
}
