package hu.poke.poketrade.repository.model;


import javax.persistence.*;

@Entity
@Table(name = "Pokemon")
public class Pokemon {
    private static final int DEFAULT_POKE_LEVEL = 1;

    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;
    @ManyToOne
    private Owner owner;
    private PokeType pokeType;
    private int level;


    public Pokemon(String name, PokeType pokeType) {
        this.name = name;
        this.pokeType = pokeType;
        this.level = DEFAULT_POKE_LEVEL;
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

    public PokeType getPokeType() {
        return pokeType;
    }

    public void setPokeType(PokeType pokeType) {
        this.pokeType = pokeType;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void jumpLevel() {
        this.level++;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
