package be.intecbrussel.pokemon.entity;

import be.intecbrussel.pokemon.services.RandomService;

import java.util.Objects;
import java.util.Random;

public class Pokemon {

    private final String name;
    private final PokeType pokeType;

    private int hp;
    private int atk;
    private int def;

    private static final int MAX_STAT = 50;
    Random rand = RandomService.getInstance();

    public Pokemon(String name, PokeType pokeType) {
        this.name = name;
        this.pokeType = pokeType;
        this.hp = generateStat();
        this.atk = generateStat();
        this.def = generateStat();
    }

    private int generateStat() {
        return rand.nextInt(MAX_STAT) + 1;
    }

    public String getName() {
        return name;
    }

    public PokeType getPokeType() {
        return pokeType;
    }

    public int getHp() {
        return hp;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public void setHp(int hp) {
        this.hp = Math.min(hp, MAX_STAT);
    }

    public void setAtk(int atk) {
        this.atk = Math.min(atk, MAX_STAT);
    }

    public void setDef(int def) {
        this.def = Math.min(def, MAX_STAT);
    }

    public void evolve() {
        setDef(getDef() + 5);
        setAtk(getAtk() + 5);
        setHp(getHp() + 5);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return hp == pokemon.hp &&
                atk == pokemon.atk &&
                def == pokemon.def &&
                name.equals(pokemon.name) &&
                pokeType == pokemon.pokeType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pokeType, hp, atk, def);
    }

    @Override
    public String toString() {
        return "Pokemon name:" + name + "\n" +
                "Pokemon type:" + pokeType + "\n" +
                "Pokemon HP:" + hp + "\n" +
                "Pokemon ATTACK:" + atk + "\n" +
                "Pokemon DEF:" + def + "\n";
    }
}
