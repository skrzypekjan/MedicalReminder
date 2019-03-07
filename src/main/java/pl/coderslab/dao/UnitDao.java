package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.domain.Unit;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class UnitDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Unit entity) {
        entityManager.persist(entity);
    }

    public Unit findById(int id) {
        return entityManager.find(Unit.class, id);
    }

    public void update(Unit entity) {
        entityManager.merge(entity);
    }

    public void delete(Unit entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

    public List<Unit> findAll() {
        Query query = entityManager.createQuery("SELECT a FROM Unit a");
        return query.getResultList();
    }
}