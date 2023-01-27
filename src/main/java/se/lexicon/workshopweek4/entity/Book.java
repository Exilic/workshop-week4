package se.lexicon.workshopweek4.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int bookId;
    @Column(nullable = false, length = 100, unique = true)
    private String isbn;
    @Column(nullable = false, unique = true)
    private String title;
    @Column(nullable = false, length = 5)
    private int maxLoanDays;

    public int getBookId() {
        return bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMaxLoanDays() {
        return maxLoanDays;
    }

    public void setMaxLoanDays(int maxLoanDays) {
        this.maxLoanDays = maxLoanDays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId == book.bookId && maxLoanDays == book.maxLoanDays && isbn.equals(book.isbn) && title.equals(book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, isbn, title, maxLoanDays);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", maxLoanDays=" + maxLoanDays +
                '}';
    }
}
