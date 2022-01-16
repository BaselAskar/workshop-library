package com.example.workshoprest.services;

import com.example.workshoprest.model.DTO.LibraryUserDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface LibraryUserService {

    LibraryUserDto findById(String id);
    LibraryUserDto findByEmail(String email);
    List<LibraryUserDto> findAll();
    LibraryUserDto create(LibraryUserDto libraryUserDto);
    LibraryUserDto update(LibraryUserDto libraryUserDto);
    boolean delete(String id);
}
