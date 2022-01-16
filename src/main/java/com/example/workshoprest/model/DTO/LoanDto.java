package com.example.workshoprest.model.DTO;

import java.time.LocalDate;

public class LoanDto {

    private String id;
    private LocalDate loanDate;
    private boolean terminated;
    private LibraryUserDto loanTaker;
    private BookDto book;

    public LoanDto() {
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

    public boolean isTerminated() {
        return terminated;
    }

    public void setTerminated(boolean terminated) {
        this.terminated = terminated;
    }

    public LibraryUserDto getLoanTaker() {
        return loanTaker;
    }

    public void setLoanTaker(LibraryUserDto loanTaker) {
        this.loanTaker = loanTaker;
    }

    public BookDto getBook() {
        return book;
    }

    public void setBook(BookDto book) {
        this.book = book;
    }
}
