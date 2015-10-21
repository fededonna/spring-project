package ar.edu.uai.paradigms.service;
import ar.edu.uai.model.Person;


public interface PersonService {

    Person savePerson(Person person);

    Person retrievePerson(String identifier);

    void deletePerson(String identifier);
}
