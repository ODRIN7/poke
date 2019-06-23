package hu.poke.poketrade.controller;

import hu.poke.poketrade.controller.param.Owner;
import hu.poke.poketrade.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OwnerController {

    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/")
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

}
