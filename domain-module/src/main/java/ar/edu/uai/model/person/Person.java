package ar.edu.uai.model.person;


import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "PERSON")
@Access(AccessType.FIELD)
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "PERSON_ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "AGE", nullable = false)
    private Integer age;

    @Column(name = "CHILDS", nullable = true)
    private ArrayList<Person> childs;

    public Person() {
    }

    public Person(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.childs = new ArrayList<Person>();
    }

    public ArrayList<Person> addChidren(Person child) {
        if(!childs.contains(child)){
            childs.add(child);
        }
        return childs;
    }

    public ArrayList<Person> getChilds() {
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
        return this.getClass().getSimpleName() + " [id=" + id + ", name=" + name + ", age=" + age + ", children=" + childs + "]";
    }
}
