package fr.perso.mvc.jpa.repository;

import fr.perso.mvc.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepo extends JpaRepository<Person, Long> {
}
