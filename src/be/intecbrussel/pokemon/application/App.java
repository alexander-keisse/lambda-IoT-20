package be.intecbrussel.pokemon.application;

import be.intecbrussel.pokemon.entity.PokeType;
import be.intecbrussel.pokemon.entity.Pokemon;
import be.intecbrussel.pokemon.entity.PokemonTrainer;
import be.intecbrussel.pokemon.filter.PokeStatFilter;
import be.intecbrussel.pokemon.filter.PokeTypeFilter;
import be.intecbrussel.pokemon.interfaces.HyperTrainer;
import be.intecbrussel.pokemon.services.DaycareService;

public class App {

    public static void main(String[] args) {

        Pokemon bulbasaur = new Pokemon("Bulbasaur", PokeType.GRASS);
        Pokemon charmander = new Pokemon("Charmander", PokeType.FIRE);
        Pokemon squirtle = new Pokemon("Squirtle", PokeType.WATER);


        PokemonTrainer alex = new PokemonTrainer("Mr Robot");

        if (alex.savePokemon(bulbasaur)) {
            System.out.println("Pokemon is saved!\n");
        } else {
            System.out.println("Something went wrong...\n");
        }

        alex.savePokemon(charmander);
        alex.savePokemon(squirtle);

        Pokemon searchResult = alex.getPokemonByName("Bulbasaur");
        System.out.println("\nPokemon that was found:\n" + searchResult);

        System.out.println(alex);

        alex.searchStat(new PokeStatFilter() {
            @Override
            public boolean filterStat(Pokemon pokemon) {
                return pokemon.getAtk() > 25;
            }
        }, bulbasaur);

        alex.searchStat(new PokeStatFilter() {
            @Override
            public boolean filterStat(Pokemon pokemon) {
                return pokemon.getHp() > 20;
            }
        }, bulbasaur);

        alex.searchStat(pokemon -> pokemon.getAtk() > 25, bulbasaur);
        alex.searchStat(pokemon -> pokemon.getHp() > 20, bulbasaur);

        // ANON CLASS

        alex.searchPokeType(new PokeTypeFilter() {
            @Override
            public Pokemon[] filterType(Pokemon... team) {

                Pokemon[] filteredTeam = new Pokemon[6];
                boolean isEmpty = true;
                for (int i = 0, index = 0; i < team.length; i++) {
                    if (team[i] != null && team[i].getPokeType() == PokeType.GRASS) {
                        filteredTeam[index++] = team[i];
                        isEmpty = false;
                    }
                }
                return isEmpty ? null : filteredTeam;
            }
        });

        // LAMBDA

        alex.searchPokeType(team -> {
            Pokemon[] filteredTeam = new Pokemon[6];
            boolean isEmpty = true;
            for (int i = 0, index = 0; i < team.length; i++) {
                if (team[i] != null && team[i].getPokeType() == PokeType.GRASS) {
                    filteredTeam[index++] = team[i];
                    isEmpty = false;
                }
            }
            return isEmpty ? null : filteredTeam;
        });


        // Static method ref

        alex.train(HyperTrainer::hyperTraining, charmander);

        // bounded instance method reference

        DaycareService service = new DaycareService();
        alex.train(service::daycareTraining, squirtle);

        // unbound instance method reference

        alex.train(Pokemon::evolve, bulbasaur);

    }

}
