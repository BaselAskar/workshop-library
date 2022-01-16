package com.example.workshoprest.services;

import com.example.workshoprest.data.repositoies.LoanDao;
import com.example.workshoprest.model.DTO.LoanDto;
import com.example.workshoprest.model.entity.Loan;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LoanServiceImp implements LoanService{

    private final LoanDao loanDao;
    private ModelMapper mapper;

    @Autowired
    public LoanServiceImp(LoanDao loanDao) {
        this.loanDao = loanDao;
        mapper = new ModelMapper();
    }

    @Override
    public LoanDto findById(String id) {
        if (id == null) throw new IllegalArgumentException("id is null!!");

        Optional<Loan> loan = loanDao.findById(id);

        if (loan.isPresent()){
            return mapper.map(loan,LoanDto.class);
        }else {
            throw new RuntimeException("the loan is not found!!");
        }
    }

    @Override
    public List<LoanDto> findAll() {
        return loanDao.findAll().stream()
                .map(loan -> mapper.map(loan,LoanDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public LoanDto create(LoanDto loanDto) {
        if (loanDto.equals(null)) throw new IllegalArgumentException("loanDto is null!!");

        Loan loan = loanDao.save(mapper.map(loanDto,Loan.class));

        return mapper.map(loan,LoanDto.class);
    }

    @Override
    public LoanDto update(LoanDto loanDto) {
        if (loanDto.equals(null)) throw new IllegalArgumentException("loanDto is null!!");

        Loan loan = loanDao.save(mapper.map(loanDto,Loan.class));

        return mapper.map(loan,LoanDto.class);

    }

    @Override
    public boolean delete(String id) {
        if (id == null) throw new IllegalArgumentException("id is null!!");

        if (loanDao.findById(id).equals(null)) throw new RuntimeException("loan is not found!!");

        loanDao.deleteById(id);

        return loanDao.findById(id).equals(null);
    }

    @Override
    public List<LoanDto> findByBookId(String bookId) {
        if (bookId.equals(null)) throw new IllegalArgumentException("bookId is null!!");

        return loanDao.findAllByBook_Id(bookId).stream()
                .map(loan -> mapper.map(loan,LoanDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<LoanDto> findByUserId(String userId) {
        if (userId.equals(null)) throw new IllegalArgumentException("userId is null!!");

        return loanDao.findAllByLoanTaker_Id(userId).stream()
                .map(loan -> mapper.map(loan,LoanDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<LoanDto> findByTerminated() {
        return loanDao.findAllByTerminate(true).stream()
                .map(loan -> mapper.map(loan,LoanDto.class))
                .collect(Collectors.toList());
    }
}
