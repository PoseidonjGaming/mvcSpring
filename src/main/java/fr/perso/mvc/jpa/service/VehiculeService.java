package fr.perso.mvc.jpa.service;

import fr.perso.mvc.jpa.repository.IVehiculeRepo;
import fr.perso.mvc.model.Vehicule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculeService implements IVehiculeService{

    @Autowired
    private IVehiculeRepo repo;

    @Override
    public List<Vehicule> getAll() {
        return repo.findAll();
    }

    @Override
    public Vehicule getById(long id) {
        return repo.findById(id).orElse(new Vehicule());
    }

    @Override
    public void save(Vehicule Vehicule) {
        repo.save(Vehicule);
    }

    @Override
    public void delete(long id) {
        repo.delete(getById(id));
    }
}
