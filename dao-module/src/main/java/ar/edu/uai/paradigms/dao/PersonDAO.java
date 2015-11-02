package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.Person;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.util.List;

/**
 * Created by Federico on 19/10/2014.
 */
public class PersonDAO implements PersistentDAO<Person, Integer, String> {

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

    @Override
    public List<Person> retrieveByCriteria(String s) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> query = cb.createQuery(Person.class);

        Root<Person> person = query.from(Person.class);
        query.where(cb.like(person.<String>get("name"),
                cb.parameter(String.class, "parameterName")));

        TypedQuery<Person> typedQuery = entityManager.createQuery(query);
        typedQuery.setParameter("parameterName", "%" + s + "%");
        return typedQuery.getResultList();
    }
}
