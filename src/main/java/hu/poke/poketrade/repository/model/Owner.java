package hu.poke.poketrade.repository.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Owner")
public class Owner {

    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @OneToMany
    private List<hu.poke.poketrade.repository.model.Pokemon> pokemons;

    public Owner(String name, List<Pokemon> pokemons) {
        this.name = name;
        this.pokemons = pokemons;
    }

    public void addNewPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}
