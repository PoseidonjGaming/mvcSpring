package fr.perso.mvc.jpa.service;

import fr.perso.mvc.jpa.repository.IPersonRepo;
import fr.perso.mvc.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService{

    @Autowired
    private IPersonRepo repo;

    @Override
    public List<Person> getAll() {
        return repo.findAll();
    }

    @Override
    public Person getById(long id) {
        return repo.findById(id).orElse(new Person());
    }

    @Override
    public void save(Person person) {
        repo.save(person);
    }
}
