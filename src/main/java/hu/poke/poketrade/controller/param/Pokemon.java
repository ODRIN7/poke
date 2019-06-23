package hu.poke.poketrade.controller.param;


public class Pokemon {
    private String name;
    private String pokeType;

    public Pokemon(String name, String pokeType) {
        this.name = name;
        this.pokeType = pokeType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPokeType() {
        return pokeType;
    }

    public void setPokeType(String pokeType) {
        this.pokeType = pokeType;
    }
}
