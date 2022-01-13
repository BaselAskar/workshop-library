package com.example.workshoprest.data.repositoies;

import com.example.workshoprest.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookDao extends JpaRepository<Book, String> {

    List<Book> findAllByReserved(boolean reserved);
    List<Book> findAllByAvailable(boolean available);
    Book findByTitle(String title);
}
