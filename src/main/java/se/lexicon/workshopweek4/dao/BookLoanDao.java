package se.lexicon.workshopweek4.dao;

import se.lexicon.workshopweek4.entity.Book;
import se.lexicon.workshopweek4.entity.BookLoan;

import java.util.Collection;

public interface BookLoanDao {
    BookLoan findById(int id);
    Collection<BookLoan> findAll();
    BookLoan create(BookLoan bookLoan);
    BookLoan update(BookLoan bookLoan);
    void delete(BookLoan bookLoan);
}
