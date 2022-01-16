package com.example.workshoprest.services;

import com.example.workshoprest.model.DTO.BookDto;

import java.util.List;

public interface BookService {

    List<BookDto> findByReserved(boolean reserved);
    List<BookDto> findByAvailable(boolean available);
    List<BookDto> findByTitle(String title);
    BookDto findById(String id);
    List<BookDto> findAll();
    BookDto create(BookDto bookDto);
    BookDto update(BookDto bookDto);
    boolean delete(String id);
}
