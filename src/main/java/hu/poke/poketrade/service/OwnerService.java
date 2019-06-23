package hu.poke.poketrade.service;

import hu.poke.poketrade.controller.param.Owner;
import hu.poke.poketrade.repository.OwnerRepository;
import hu.poke.poketrade.repository.PokemonRepository;
import hu.poke.poketrade.repository.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;
    private final PokemonRepository pokemonRepository;

    @Autowired
    public OwnerService(OwnerRepository ownerRepository, PokemonRepository pokemonRepository) {
        this.ownerRepository = ownerRepository;
        this.pokemonRepository = pokemonRepository;
    }

    public void createNewOwner(Owner owner) {
        ownerRepository.save(convert(owner));
    }

    public List<Owner> getOwners() {
        List<Owner> owners = new ArrayList<>();
        ownerRepository.findAll().forEach(owner -> owners.add(new Owner(owner.getName(),
                convertToPokemonParam(owner.getPokemons()))));
        return owners;
    }

    private hu.poke.poketrade.repository.model.Owner convert(Owner owner) {
        return new hu.poke.poketrade.repository.model.Owner(owner.getName(),
                convertToPokemonEntity(owner.getPokemons()));
    }

    public Owner getOwnerById(Long userId) {
        hu.poke.poketrade.repository.model.Owner owner = ownerRepository.findById(userId).get();
        return new Owner(owner.getName(),
                convertToPokemonParam(owner.getPokemons()));
    }

    public void doTradePokemon(Long firstOwnerId, Long firstPokemonId,
                               Long otherOwnerId, Long otherPokemonId) {
        hu.poke.poketrade.repository.model.Owner firstOwner = ownerRepository.findById(firstOwnerId).get();
        Pokemon firstPokemon = pokemonRepository.findById(otherPokemonId).get();

        hu.poke.poketrade.repository.model.Owner otherOwner = ownerRepository.findById(otherOwnerId).get();
        Pokemon otherPokemon = pokemonRepository.findById(firstPokemonId).get();

        if (isSameTypeAndLowerLevel(firstPokemon, otherPokemon)) {
            firstPokemon.jumpLevel();
        }

        firstOwner.addNewPokemon(firstPokemon);
        otherOwner.addNewPokemon(otherPokemon);

    }

    private boolean isSameTypeAndLowerLevel(Pokemon firstPokemon, Pokemon otherPokemon) {
        return !firstPokemon.getPokeType().equals(otherPokemon.getPokeType()) &&
                firstPokemon.getLevel() <= otherPokemon.getLevel();
    }

    private List<Pokemon> convertToPokemonEntity(List<hu.poke.poketrade.controller.param.Pokemon> pokemons) {
        List<Pokemon> result = new ArrayList<>();
        for (int i = 0; i < pokemons.size(); i++) {
            pokemons.add(pokemons.get(i));
        }
        return result;
    }

    private List<hu.poke.poketrade.controller.param.Pokemon> convertToPokemonParam(List<Pokemon> pokemons) {
        List<hu.poke.poketrade.controller.param.Pokemon> result = new ArrayList<>();
        for (int i = 0; i < pokemons.size(); i++) {
            pokemons.add(pokemons.get(i));
        }
        return result;
    }
}
