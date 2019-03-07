package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.domain.Glucometer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class GlucometerDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Glucometer entity) {
        entityManager.persist(entity);
    }

    public Glucometer findById(int id) {
        return entityManager.find(Glucometer.class, id);
    }

    public void update(Glucometer entity) {
        entityManager.merge(entity);
    }

    public void delete(Glucometer entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

    public List<Glucometer> findAll() {
        Query query = entityManager.createQuery("SELECT a FROM Glucometer a");
        return query.getResultList();
    }
}
