package se.lexicon.workshopweek4.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.workshopweek4.entity.Details;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class DetailsDaoImpl implements DetailsDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public Details findById(int id) {
        return entityManager.find(Details.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Details> findAll() {
        return entityManager
                .createQuery("Select d from Details d", Details.class)
                .getResultList();
    }

    @Override
    @Transactional
    public Details create(Details details) {
        if(details == null) throw new NullPointerException("Details provided is null");
        entityManager.persist(details);
        return details;
    }

    @Override
    @Transactional
    public Details update(Details details) {
        if(details == null) throw new NullPointerException("Details provided is null");
        entityManager.merge(details);
        return details;
    }

    @Override
    @Transactional
    public void delete(Details details) {
        if(details == null) throw new NullPointerException("Details provided is null");
        entityManager.remove(details);
    }
}
