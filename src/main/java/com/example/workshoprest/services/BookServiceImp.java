package com.example.workshoprest.services;

import com.example.workshoprest.data.repositoies.BookDao;
import com.example.workshoprest.model.DTO.BookDto;
import com.example.workshoprest.model.entity.Book;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImp implements BookService{

    private final BookDao bookDao;
    private final ModelMapper mapper;

    @Autowired
    public BookServiceImp(BookDao bookDao) {
        this.bookDao = bookDao;
        this.mapper = new ModelMapper();
    }

    @Override
    public List<BookDto> findByReserved(boolean reserved) {
        List<Book> books = bookDao.findAllByReserved(reserved);
        return books.stream()
                .map(book -> mapper.map(book,BookDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDto> findByAvailable(boolean available) {
        List<Book> books = bookDao.findAllByAvailable(available);
        return books.stream()
                .map(book -> mapper.map(book,BookDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDto> findByTitle(String title) {
        List<Book> books = bookDao.findAllByTitle(title);
        return books.stream()
                .map(book -> mapper.map(book,BookDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public BookDto findById(String id) {
        if (id == null) throw new IllegalArgumentException("id is null!!");

        Optional<Book> book = bookDao.findById(id);
        if (book.isPresent()){
            return mapper.map(book,BookDto.class);
        }else {
            throw new RuntimeException("the book is not eisted");
        }
    }

    @Override
    public List<BookDto> findAll() {
        return bookDao.findAll().stream()
                .map(book -> mapper.map(book,BookDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public BookDto create(BookDto bookDto) {
        if (bookDto == null) throw new IllegalArgumentException("book is null!!");

        Book book = bookDao.save(mapper.map(bookDto,Book.class));

        return mapper.map(book,BookDto.class);
    }

    @Override
    public BookDto update(BookDto bookDto) {
        if (bookDto == null) throw new IllegalArgumentException("book is null!!");

        Book book = bookDao.save(mapper.map(bookDto,Book.class));

        return mapper.map(book,BookDto.class);

    }

    @Override
    public boolean delete(String id) {
        if (id == null) throw new IllegalArgumentException("id is null!");

        if (bookDao.findById(id).equals(null)) return false;

        bookDao.deleteById(id);

        return true;
    }
}
