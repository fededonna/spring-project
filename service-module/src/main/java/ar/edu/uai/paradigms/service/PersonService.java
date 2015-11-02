package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.Person;


public interface PersonService {

    Person savePerson(Person person);

    Person retrievePerson(Integer identifier);

    void deletePerson(Integer identifier);
}
