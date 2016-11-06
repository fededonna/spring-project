package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.person.Person;
import ar.edu.uai.model.person.PersonCriteria;

import java.util.List;


public interface PersonService {

    Person savePerson(Person person);

    Person retrievePerson(Integer identifier);

    void deletePerson(Integer identifier);

    Person addChildren(Integer identifier, Person children);

    List<Person> retrieveByCriteria(PersonCriteria criteria);
}
