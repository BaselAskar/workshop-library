package com.example.workshoprest.data.repositoies;

import com.example.workshoprest.model.entity.LibraryUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryUserDao extends JpaRepository<LibraryUser,String> {

    LibraryUser findByEmailIgnoringCase(String email);
}
