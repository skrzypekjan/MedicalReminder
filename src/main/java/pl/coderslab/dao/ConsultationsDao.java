package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.domain.Consultations;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class ConsultationsDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Consultations entity) {
        entityManager.persist(entity);
    }

    public Consultations findById(int id) {
        return entityManager.find(Consultations.class, id);
    }

    public void update(Consultations entity) {
        entityManager.merge(entity);
    }

    public void delete(Consultations entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

    public List<Consultations> findAll() {
        Query query = entityManager.createQuery("SELECT a FROM Consultations a");
        return query.getResultList();
    }

}
