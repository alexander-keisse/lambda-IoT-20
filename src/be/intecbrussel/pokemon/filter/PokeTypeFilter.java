package be.intecbrussel.pokemon.filter;

import be.intecbrussel.pokemon.entity.Pokemon;

@FunctionalInterface
public interface PokeTypeFilter {

    Pokemon [] filterType(Pokemon ... team);

}
