package se.lexicon.workshopweek4.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class BookLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int loanId;
    @Column(nullable = false, length = 15)
    private LocalDate loanDate;
    @Column(nullable = false, length = 15)
    private LocalDate dueDate;
    @Column(nullable = false)
    private Boolean returned;
    @ManyToOne
    @JoinColumn(name = "app_user_id")
    private AppUser borrower;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public int getLoanId() {
        return loanId;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getReturned() {
        return returned;
    }

    public void setReturned(Boolean returned) {
        this.returned = returned;
    }

    public AppUser getBorrower() {
        return borrower;
    }

    public void setBorrower(AppUser borrower) {
        this.borrower = borrower;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookLoan bookLoan = (BookLoan) o;
        return loanId == bookLoan.loanId && loanDate.equals(bookLoan.loanDate) && dueDate.equals(bookLoan.dueDate) && returned.equals(bookLoan.returned) && borrower.equals(bookLoan.borrower) && book.equals(bookLoan.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanId, loanDate, dueDate, returned, borrower, book);
    }

    @Override
    public String toString() {
        return "BookLoan{" +
                "loanId=" + loanId +
                ", loanDate=" + loanDate +
                ", dueDate=" + dueDate +
                ", returned=" + returned +
                ", borrower=" + borrower +
                ", book=" + book +
                '}';
    }
}
