package com.example.workshoprest.controller;

import com.example.workshoprest.model.DTO.LibraryUserDto;
import com.example.workshoprest.services.LibraryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryUserController {

    private LibraryUserService libraryUserService;

    @Autowired
    public LibraryUserController(LibraryUserService libraryUserService) {
        this.libraryUserService = libraryUserService;
    }

    @GetMapping("/api/v1/users/{userId}")
    public ResponseEntity<LibraryUserDto> finnById(@PathVariable("userId") String userId){
        LibraryUserDto user = libraryUserService.findById(userId);

        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/api/v1/users")
    public ResponseEntity<List<LibraryUserDto>> findAll(){
        List<LibraryUserDto> libraryUsers = libraryUserService.findAll();
        return ResponseEntity.ok().body(libraryUsers);
    }

    @PostMapping("/api/v1/users/create")
    public ResponseEntity<LibraryUserDto> create(@RequestBody LibraryUserDto libraryUserDto){
        LibraryUserDto libraryUser = libraryUserService.create(libraryUserDto);
        return ResponseEntity.ok().body(libraryUser);
    }

    @PutMapping("/api/v1/users/update")
    public ResponseEntity<LibraryUserDto> update(@RequestBody LibraryUserDto libraryUserDto){
        LibraryUserDto libraryUser = libraryUserService.update(libraryUserDto);
        return ResponseEntity.ok().body(libraryUser);
    }
}
