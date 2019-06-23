package hu.poke.poketrade.controller;

import hu.poke.poketrade.controller.param.Pokemon;
import hu.poke.poketrade.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PokeController {

    private final PokemonService pokemonService;

    @Autowired
    public PokeController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/")
    public List<Pokemon> getPokemons() {
        return pokemonService.getPokemons();
    }

    @GetMapping("/{pokemonId}")
    public Pokemon getPokemonById(@PathVariable("pokemonId") Long pokemonId) {
        return pokemonService.getPokemonById(pokemonId);
    }

    @PostMapping("/")
    public void createPokemon(@RequestBody Pokemon pokemon) {
        pokemonService.createNewPokemon(pokemon);
    }

    @PutMapping("/")
    public void upgradePokemon(@RequestBody Pokemon pokemon) {
        pokemonService.createNewPokemon(pokemon);
    }
}
