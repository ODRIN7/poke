package hu.poke.poketrade.controller;

import hu.poke.poketrade.controller.param.Owner;
import hu.poke.poketrade.controller.param.PokeTradeParam;
import hu.poke.poketrade.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/owner")
public class OwnerController {

    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/owners")
    public List<Owner> getOwners() {
        return ownerService.getOwners();
    }

    @GetMapping("/{ownerId}")
    public Owner getOwnerById(@PathVariable("ownerId") Long ownerId) {
        return ownerService.getOwnerById(ownerId);
    }

    @PostMapping("/")
    public void createOwner(@RequestBody Owner owner) {
        ownerService.createNewOwner(owner);
    }

    @PostMapping("/pokeTrade")
    public void pokeTrade(@RequestBody PokeTradeParam pokeTradeParam) {
        ownerService.doTradePokemon(pokeTradeParam.getFirstOwnerId(), pokeTradeParam.getFirstPokemonId(),
                pokeTradeParam.getOtherOwnerId(), pokeTradeParam.getOtherPokemonId());
    }

}
