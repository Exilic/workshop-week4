package se.lexicon.workshopweek4.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.workshopweek4.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class BookDaoImpl implements BookDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public Book findById(int id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Book> findAll() {
        return entityManager
                .createQuery("Select b from Book b", Book.class)
                .getResultList();
    }

    @Override
    @Transactional
    public Book create(Book book) {
        if(book == null) throw new NullPointerException("Book provided is null");
        entityManager.persist(book);
        return book;
    }

    @Override
    @Transactional
    public Book update(Book book) {
        if(book == null) throw new NullPointerException("Book provided is null");
        entityManager.merge(book);
        return book;
    }

    @Override
    @Transactional
    public void delete(Book book) {
        if(book == null) throw new NullPointerException("Book provided is null");
        entityManager.remove(book);
    }
}
