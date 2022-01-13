package com.example.workshoprest.data.repositoies;

import com.example.workshoprest.model.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanDao extends JpaRepository<Loan,String> {

    List<Loan> findAllByLoanTaker_Id(String userId);
    List<Loan> findAllByBook_Id(String bookId);
    List<Loan> findAllByTerminate(boolean terminate);

}
