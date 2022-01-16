package com.example.workshoprest.services;

import com.example.workshoprest.model.DTO.LoanDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface LoanService {

    LoanDto findById(String id);
    List<LoanDto> findAll();
    LoanDto create(LoanDto loanDto);
    LoanDto update(LoanDto loanDto);
    boolean delete(String id);
    List<LoanDto> findByBookId(String bookId);
    List<LoanDto> findByUserId(String userId);
    List<LoanDto> findByTerminated();
}
