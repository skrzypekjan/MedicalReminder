package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.domain.Medicines;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class MedicinesDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Medicines entity) {
        entityManager.persist(entity);
    }

    public Medicines findById(int id) {
        return entityManager.find(Medicines.class, id);
    }

    public void update(Medicines entity) {
        entityManager.merge(entity);
    }

    public void delete(Medicines entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

    public List<Medicines> findAll() {
        Query query = entityManager.createQuery("SELECT a FROM Medicines a");
        return query.getResultList();
    }
}