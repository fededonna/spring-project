package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Person;
import ar.edu.uai.paradigms.dto.PersonDTO;

public class PersonTranslator {

    public Person translate(PersonDTO personDTO) {
        return new Person(personDTO.getId(), personDTO.getName(), personDTO.getAge());
    }

    public PersonDTO translateToDTO(Person person) {
        if (person != null) {
            return new PersonDTO(person.getId(), person.getName(), person.getAge());
        }
        return null;
    }
}
