package fr.perso.mvc.jpa.repository;

import fr.perso.mvc.model.Person;
import fr.perso.mvc.model.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVehiculeRepo extends JpaRepository<Vehicule, Long> {
}
