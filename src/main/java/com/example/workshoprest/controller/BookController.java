package com.example.workshoprest.controller;

import com.example.workshoprest.model.DTO.BookDto;
import com.example.workshoprest.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/api/v1/books/{bookId}")
    public ResponseEntity<BookDto> findById(@PathVariable("bookId") String bookId){
        BookDto book = bookService.findById(bookId);
        return ResponseEntity.ok().body(book);
    }

    @GetMapping("/api/v1/books")
    public ResponseEntity<List<BookDto>> findAll(){
        List<BookDto> books = bookService.findAll();
        return ResponseEntity.ok().body(books);
    }

    @PostMapping("/api/v1/books/create")
    public ResponseEntity<BookDto> create(@RequestBody BookDto bookDto){
        BookDto book = bookService.create(bookDto);
        return ResponseEntity.ok().body(book);
    }

    @PutMapping("/api/v1/books/update")
    public ResponseEntity<BookDto> update(@RequestBody BookDto bookDto){
        BookDto book = bookService.update(bookDto);
        return ResponseEntity.ok().body(book);
    }
}
