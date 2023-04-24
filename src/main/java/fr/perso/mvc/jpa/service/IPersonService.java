package fr.perso.mvc.jpa.service;

import fr.perso.mvc.model.Person;

import java.util.List;

public interface IPersonService {
    List<Person> getAll();
    Person getById(long id);

    void save(Person person);
    void delete(long id);
}
