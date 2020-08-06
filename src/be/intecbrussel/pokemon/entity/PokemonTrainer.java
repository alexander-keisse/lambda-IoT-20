package be.intecbrussel.pokemon.entity;

import be.intecbrussel.pokemon.exceptions.NoPokemonFoundException;
import be.intecbrussel.pokemon.exceptions.NoValidSearchException;
import be.intecbrussel.pokemon.filter.PokeStatFilter;
import be.intecbrussel.pokemon.filter.PokeTypeFilter;
import be.intecbrussel.pokemon.interfaces.Handler;

import java.util.Arrays;

public class PokemonTrainer {

    private final String nickname;
    private final Pokemon [] team = new Pokemon[6];

    public PokemonTrainer(String nickname) {
        this.nickname = nickname;
    }

    public boolean savePokemon(Pokemon pokemon) {
        if (pokemon != null) {
            for (int i = 0; i < team.length; i++) {
                if (team[i] == null) {
                    team[i] = pokemon;
                    return true;
                }
            }
            System.out.println("Sorry no more place in your team for an extra Pokemon!\n" +
                    "Make room first!");
        }
        System.out.println("Please try again with a valid Pokemon!");
        return false;
    }

    public boolean deletePokemon(Pokemon pokemon) {
        if (pokemon != null) {
            for (int i = 0; i < team.length; i++) {
                if (pokemon.equals(team[i])) {
                    team[i] = null;
                    return true;
                }
            }
        }
        return false;
    }

    public Pokemon getPokemonByName(String name) throws NoPokemonFoundException, NoValidSearchException {

        if (name != null) {
            name = name.replace(" ","");

            if (! name.isEmpty()) {

                for (Pokemon pokemon : team) {

                    if (name.equals(pokemon.getName())) {
                        return pokemon;
                    }
                }

                throw new NoPokemonFoundException(name.toUpperCase() + " not found!");
            }
        }
        throw new NoValidSearchException("Not a valid search!");
    }

    public Pokemon[] getTeam() {
        return team;
    }

    public void searchStat(PokeStatFilter filter, Pokemon pokemon) {

        if (filter.filterStat(pokemon)) {
            System.out.println("Pokemon meets the requirements.\n");
        } else{
            System.out.println("Pokemon does not meet the requirements!\n");
        }
    }

    public void searchPokeType(PokeTypeFilter filter) {

        Pokemon [] filteredTeam = filter.filterType(team);

        if (filteredTeam != null) {
            System.out.println("Pokemon type is found!\n");

            for (Pokemon p: filteredTeam) {

                if (p != null) System.out.println(p);
            }

        }else  {

            System.out.println("No Pokemon in your team has this type!\n");
        }
    }

    public void train(Handler handler, Pokemon pokemon) {

        handler.handle(pokemon);
    }

    @Override
    public String toString() {
        return "PokemonTrainer{" +
                "nickname='" + nickname + '\'' +
                ", team=" + Arrays.toString(team) +
                "}\n";
    }
}
