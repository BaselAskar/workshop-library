package com.example.workshoprest.services;

import com.example.workshoprest.data.repositoies.LibraryUserDao;
import com.example.workshoprest.model.DTO.LibraryUserDto;
import com.example.workshoprest.model.entity.LibraryUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibraryUserServiceImp implements LibraryUserService{

    private final LibraryUserDao libraryUserDao;
    private final ModelMapper mapper;



    @Autowired
    public LibraryUserServiceImp(LibraryUserDao libraryUserDao) {
        this.libraryUserDao = libraryUserDao;
        this.mapper = new ModelMapper();
    }

    @Override
    public LibraryUserDto findById(String id) {
        Optional<LibraryUser> libraryUser = libraryUserDao.findById(id);


        if (libraryUser.isPresent()){
            return mapper.map(libraryUser,LibraryUserDto.class);
        }else {
            throw new IllegalArgumentException("This user is not found");
        }

    }

    @Override
    public LibraryUserDto findByEmail(String email) {

        LibraryUser libraryUser = libraryUserDao.findByEmailIgnoringCase(email);

        if (libraryUser != null){
            return mapper.map(libraryUser,LibraryUserDto.class);
        }else{
            throw new IllegalArgumentException("The user is not existed!!");
        }
    }

    @Override
    public List<LibraryUserDto> findAll() {
        List<LibraryUser> libraryUsers = libraryUserDao.findAll();

        return libraryUsers.stream()
                .map(user -> mapper.map(user,LibraryUserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public LibraryUserDto create(LibraryUserDto libraryUserDto) {
        LibraryUser libraryUser = mapper.map(libraryUserDto,LibraryUser.class);

        LibraryUser libraryUserPersisted = libraryUserDao.save(libraryUser);

        return mapper.map(libraryUserPersisted,LibraryUserDto.class);
    }

    @Override
    public LibraryUserDto update(LibraryUserDto libraryUserDto) {
        LibraryUser libraryUser = mapper.map(libraryUserDto,LibraryUser.class);

        LibraryUser libraryUserPersisted = libraryUserDao.save(libraryUser);

        return mapper.map(libraryUserPersisted,LibraryUserDto.class);

    }

    @Override
    public boolean delete(String id) {
        if (id == null) throw new IllegalArgumentException();
        Optional<LibraryUser> libraryUser = libraryUserDao.findById(id);

        if (libraryUser.isPresent()){
            libraryUserDao.deleteById(id);
            return true;
        }else {
            return false;
        }

    }
}
