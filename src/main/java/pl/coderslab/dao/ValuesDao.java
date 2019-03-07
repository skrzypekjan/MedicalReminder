package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.domain.Values;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class ValuesDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Values entity) {
        entityManager.persist(entity);
    }

    public Values findById(int id) {
        return entityManager.find(Values.class, id);
    }

    public void update(Values entity) {
        entityManager.merge(entity);
    }

    public void delete(Values entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

    public List<Values> findAll() {
        Query query = entityManager.createQuery("SELECT a FROM Values a");
        return query.getResultList();
    }
}
