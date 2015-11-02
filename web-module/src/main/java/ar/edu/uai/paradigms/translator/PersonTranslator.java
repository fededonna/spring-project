package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Person;
import ar.edu.uai.paradigms.dto.PersonDTO;

import java.util.ArrayList;
import java.util.List;

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

    public List<PersonDTO> translateToDTO(List<Person> persons) {
        List<PersonDTO> personResponse = new ArrayList<PersonDTO>();
        for(Person p : persons) {
            PersonDTO personDTO = this.translateToDTO(p);
            if(personDTO != null) {
                personResponse.add(personDTO);
            }
        }
        return personResponse;
    }
}
