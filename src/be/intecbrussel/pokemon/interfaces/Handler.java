package be.intecbrussel.pokemon.interfaces;

import be.intecbrussel.pokemon.entity.Pokemon;

@FunctionalInterface
public interface Handler {

    void handle(Pokemon pokemon);

}
