package hu.poke.poketrade.service;

import hu.poke.poketrade.controller.param.Owner;
import hu.poke.poketrade.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;

    @Autowired
    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public void createNewOwner(Owner owner) {
        ownerRepository.save(convert(owner));
    }

    public List<Owner> getOwners() {
        List<Owner> owners = new ArrayList<>();
        ownerRepository.findAll().forEach(owner -> owners.add(new Owner(owner.getName())));
        return owners;
    }

    private hu.poke.poketrade.repository.model.Owner convert(Owner owner) {
        return new hu.poke.poketrade.repository.model.Owner(owner.getName());
    }

    public Owner getOwnerById(Long userId) {
        return new Owner(ownerRepository.findById(userId).get().getName());
    }
}
