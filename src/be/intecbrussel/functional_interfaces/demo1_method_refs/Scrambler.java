package be.intecbrussel.functional_interfaces.demo1_method_refs;

import java.util.Random;

@FunctionalInterface
interface ParseAble {

    Integer parse(Character c);
}

public class Scrambler {

    private final String original;
    private final Integer[] scrambled;
    private final int key;

    public Scrambler(String original, int key) {

        if (original.isEmpty()) throw new RuntimeException("not a valid string to scramble");
        if (key < 0) throw new RuntimeException("Not a valid key");

        this.original = original;
        this.key = key;
        scrambled = new Integer[original.length()];
    }

    // TODO: Add a seed to descramble
    public void scramble(ParseAble parser) {

        for (int i = 0; i < original.length(); i++) {
            scrambled[i] = parser.parse(original.charAt(i)) + new Random().nextInt(key);
        }
    }

    public Integer[] getScrambled() {
        return scrambled;
    }
}