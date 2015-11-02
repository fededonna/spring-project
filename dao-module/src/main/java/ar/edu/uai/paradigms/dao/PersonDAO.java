package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Federico on 19/10/2014.
 */
public class PersonDAO implements PersistentDAO<Person, Integer> {

    @PersistenceContext(unitName = "paradigms-persistence-unit")
    private EntityManager entityManager;

    @Override
    public Person create(Person person) {
        this.entityManager.persist(person);
        return person;
    }

    @Override
    public Person retrieve(Integer id) {
        return this.entityManager.find(Person.class, id);
    }

    @Override
    public Person update(Person person) {
        return this.entityManager.merge(person);
    }

    @Override
    public void delete(Integer id) {
        this.entityManager.remove(this.retrieve(id));
    }
}
