package com.example.workshoprest.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

import static com.example.workshoprest.model.constants.EntityConstants.GENERATOR;
import static com.example.workshoprest.model.constants.EntityConstants.UUID_GENERATOR;

@Entity
public class LibraryUser {

    @Id
    @GeneratedValue(generator = GENERATOR)
    @GenericGenerator(name = GENERATOR,strategy = UUID_GENERATOR)
    private String id;
    private String name;

    @Column(unique = true)
    private String email;
    private LocalDate regDate;

    public LibraryUser() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibraryUser that = (LibraryUser) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(regDate, that.regDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, regDate);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    @Override
    public String toString() {
        return "LibraryUser{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", regDate=" + regDate +
                '}';
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }
}
