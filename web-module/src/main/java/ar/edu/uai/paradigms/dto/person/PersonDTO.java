package ar.edu.uai.paradigms.dto.person;

import ar.edu.uai.model.person.Person;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by Federico Donnarumma on 10/15/14.
 */
public class PersonDTO {

    private Integer id;

    private String name;
    private int age;

    private ArrayList<Integer> childs;

    @JsonCreator
    public PersonDTO(@JsonProperty("id") Integer id, @JsonProperty("name") String name, @JsonProperty("age") int age, @JsonProperty("childs") ArrayList<Person> childs) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.childs = new ArrayList<Integer>();
        if(childs != null && childs.size() > 0){
            Object arrChilds = childs.toArray();
            for(Person child: (Person[])arrChilds){
                this.childs.add(child.getId());
            }
        }
    }

    public ArrayList<Integer> getChilds() {
        return childs;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [id=" + id + ", name=" + name + ", age=" + age + ", childs=" + childs + " ]";
    }

}
