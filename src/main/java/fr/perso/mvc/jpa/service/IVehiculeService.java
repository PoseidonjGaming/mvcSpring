package fr.perso.mvc.jpa.service;

import fr.perso.mvc.model.Vehicule;

import java.util.List;

public interface IVehiculeService {
    List<Vehicule> getAll();
    Vehicule getById(long id);

    void save(Vehicule Vehicule);
    void delete(long id);
}
