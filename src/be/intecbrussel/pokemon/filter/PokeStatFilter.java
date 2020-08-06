package be.intecbrussel.pokemon.filter;

import be.intecbrussel.pokemon.entity.Pokemon;

@FunctionalInterface
public interface PokeStatFilter {

    boolean filterStat(Pokemon pokemon);

}
