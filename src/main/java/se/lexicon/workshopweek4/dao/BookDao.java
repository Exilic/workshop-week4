package se.lexicon.workshopweek4.dao;

import se.lexicon.workshopweek4.entity.AppUser;
import se.lexicon.workshopweek4.entity.Book;

import java.util.Collection;

public interface BookDao {
    Book findById(int id);
    Collection<Book> findAll();
    Book create(Book book);
    Book update(Book book);
    void delete(Book book);
}
