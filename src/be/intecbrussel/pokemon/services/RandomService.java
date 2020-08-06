package be.intecbrussel.pokemon.services;

import java.util.Random;

public class RandomService {

    // static variable single_instance of type Singleton
    private static Random random = null;

    // private constructor restricted to this class itself
    private RandomService() {

    }

    // static method to create instance of Singleton class
    public static Random getInstance() {
        return (random == null) ? new Random(42) : random;
    }
}
