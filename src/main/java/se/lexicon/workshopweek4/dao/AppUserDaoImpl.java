package se.lexicon.workshopweek4.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.workshopweek4.entity.AppUser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class AppUserDaoImpl implements AppUserDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public AppUser findById(int id) {
        return entityManager.find(AppUser.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<AppUser> findAll() {
        return entityManager
                .createQuery("Select a from AppUser a", AppUser.class)
                .getResultList();
    }

    @Override
    @Transactional
    public AppUser create(AppUser appUser) {
        if(appUser == null) throw new NullPointerException("AppUser provided is null");
        entityManager.persist(appUser);
        return appUser;
    }

    @Override
    @Transactional
    public AppUser update(AppUser appUser) {
        if(appUser == null) throw new NullPointerException("AppUser provided is null");
        entityManager.merge(appUser);
        return appUser;
    }

    @Override
    @Transactional
    public void delete(AppUser appUser) {
        if(appUser == null) throw new NullPointerException("AppUser provided is null");
        entityManager.remove(appUser);
    }
}
