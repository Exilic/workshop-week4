package se.lexicon.workshopweek4.dao;

import se.lexicon.workshopweek4.entity.AppUser;

import java.util.Collection;

public interface AppUserDao {
    AppUser findById(int id);
    Collection<AppUser> findAll();
    AppUser create(AppUser appUser);
    AppUser update(AppUser appUser);
    void delete(AppUser appUser);
}
