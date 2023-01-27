package se.lexicon.workshopweek4.dao;

import org.springframework.transaction.annotation.Transactional;
import se.lexicon.workshopweek4.entity.BookLoan;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

public class BookLoanDaoImpl implements BookLoanDao{

    @PersistenceContext
    EntityManager entityManager;


    @Override
    @Transactional(readOnly = true)
    public BookLoan findById(int id) {
        return entityManager.find(BookLoan.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<BookLoan> findAll() {
        return entityManager
                .createQuery("Select b from BookLoan b", BookLoan.class)
                .getResultList();
    }

    @Override
    @Transactional
    public BookLoan create(BookLoan bookLoan) {
        if(bookLoan == null) throw new NullPointerException("BookLoan provided is null");
        entityManager.persist(bookLoan);
        return bookLoan;
    }

    @Override
    @Transactional
    public BookLoan update(BookLoan bookLoan) {
        if(bookLoan == null) throw new NullPointerException("BookLoan provided is null");
        entityManager.merge(bookLoan);
        return bookLoan;
    }

    @Override
    @Transactional
    public void delete(BookLoan bookLoan) {
        if(bookLoan == null) throw new NullPointerException("BookLoan provided is null");
        entityManager.remove(bookLoan);
    }
}
