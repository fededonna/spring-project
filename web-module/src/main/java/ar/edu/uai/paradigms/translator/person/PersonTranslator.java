package ar.edu.uai.paradigms.translator.person;

import ar.edu.uai.model.person.Person;
import ar.edu.uai.model.person.PersonCriteria;
import ar.edu.uai.paradigms.dto.person.PersonCriteriaDTO;
import ar.edu.uai.paradigms.dto.person.PersonDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonTranslator {

    public Person translate(PersonDTO personDTO) {
        return new Person(personDTO.getId(), personDTO.getName(), personDTO.getAge());
    }

    public PersonDTO translateToDTO(Person person) {
        if (person != null) {
            return new PersonDTO(person.getId(), person.getName(), person.getAge(), getChildrenIds(person));
        }
        return null;
    }

    private List<Integer> getChildrenIds(Person person) {
        List<Integer> childs = new ArrayList<Integer>();
        for(Person p : person.getChilds()) {
            childs.add(p.getId());
        }
        return childs;
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

    public PersonCriteria translateCriteria(PersonCriteriaDTO personCriteriaDTO) {
        return new PersonCriteria(personCriteriaDTO.getName(), personCriteriaDTO.getMinAge(), personCriteriaDTO.getMaxAge());
    }

}
