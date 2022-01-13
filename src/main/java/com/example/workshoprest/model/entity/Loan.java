package com.example.workshoprest.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

import static com.example.workshoprest.model.constants.EntityConstants.GENERATOR;
import static com.example.workshoprest.model.constants.EntityConstants.UUID_GENERATOR;

@Entity
public class Loan {

    @Id
    @GeneratedValue(generator = GENERATOR)
    @GenericGenerator(name = GENERATOR,strategy = UUID_GENERATOR)
    private String id;

    private LocalDate loanDate;
    private boolean terminate;

    @ManyToOne(
            cascade = {CascadeType.DETACH,CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "fk_library_user_id")
    private LibraryUser loanTaker;

    @ManyToOne(
            cascade = {CascadeType.DETACH,CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "fk_book_id")
    private Book book;

    public Loan() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public boolean isTerminate() {
        return terminate;
    }

    public void setTerminate(boolean terminate) {
        this.terminate = terminate;
    }

    public LibraryUser getLoanTaker() {
        return loanTaker;
    }

    public void setLoanTaker(LibraryUser loanTaker) {
        this.loanTaker = loanTaker;
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
        Loan loan = (Loan) o;
        return terminate == loan.terminate && Objects.equals(id, loan.id) && Objects.equals(loanDate, loan.loanDate) && Objects.equals(loanTaker, loan.loanTaker) && Objects.equals(book, loan.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, loanDate, terminate, loanTaker, book);
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id='" + id + '\'' +
                ", loanDate=" + loanDate +
                ", terminate=" + terminate +
                ", loanTaker=" + loanTaker +
                ", book=" + book +
                '}';
    }
}
