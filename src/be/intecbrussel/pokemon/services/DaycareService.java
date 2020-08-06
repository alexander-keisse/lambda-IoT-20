package be.intecbrussel.pokemon.services;

import be.intecbrussel.pokemon.entity.Pokemon;

import java.util.Random;

public class DaycareService {

    public void daycareTraining(Pokemon pokemon) throws NullPointerException{
        Random random = RandomService.getInstance();
        final int bound = 2;
        final int iterations = 20;

        if (pokemon != null) {

            for (int i = 0; i < iterations; i++) {

                pokemon.setHp(pokemon.getHp() + (random.nextInt(bound)));
                pokemon.setAtk(pokemon.getAtk() + (random.nextInt(bound)));
                pokemon.setDef(pokemon.getDef() + (random.nextInt(bound)));
            }
        }
        throw new NullPointerException();
    }

}
