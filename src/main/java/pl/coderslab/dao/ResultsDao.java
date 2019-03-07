package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.domain.Results;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class ResultsDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Results entity) {
        entityManager.persist(entity);
    }

    public Results findById(int id) {
        return entityManager.find(Results.class, id);
    }

    public void update(Results entity) {
        entityManager.merge(entity);
    }

    public void delete(Results entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

    public List<Results> findAll() {
        Query query = entityManager.createQuery("SELECT a FROM Results a");
        return query.getResultList();
    }
}
