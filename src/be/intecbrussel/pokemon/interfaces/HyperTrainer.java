package be.intecbrussel.pokemon.interfaces;

import be.intecbrussel.pokemon.entity.Pokemon;

public interface HyperTrainer {

    static void hyperTraining(Pokemon pokemon) {

        pokemon.setAtk(50);
        pokemon.setHp(50);
        pokemon.setDef(50);
    }

}
