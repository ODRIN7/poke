package hu.poke.poketrade.service;

import hu.poke.poketrade.controller.param.Pokemon;
import hu.poke.poketrade.repository.PokemonRepository;
import hu.poke.poketrade.repository.model.PokeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonService {
    private final PokemonRepository pokemonRepository;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public void createNewPokemon(Pokemon pokemon) {
        pokemonRepository.save(convert(pokemon));
    }

    public List<Pokemon> getPokemons() {
        List<Pokemon> pokemons = new ArrayList<>();
        pokemonRepository.findAll().forEach(pokemon -> pokemons.add(new Pokemon(pokemon.getName(),
                pokemon.getPokeType().name())));
        return pokemons;
    }

    private hu.poke.poketrade.repository.model.Pokemon convert(Pokemon pokemon) {
        return new hu.poke.poketrade.repository.model.Pokemon(pokemon.getName(), PokeType.valueOf(pokemon.getPokeType()));
    }

    public Pokemon getPokemonById(Long pokemonId) {
        hu.poke.poketrade.repository.model.Pokemon pokemon = pokemonRepository.findById(pokemonId).get();
        return new Pokemon(pokemon.getName(), pokemon.getPokeType().name());
    }
}
