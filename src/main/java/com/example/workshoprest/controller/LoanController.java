package com.example.workshoprest.controller;

import com.example.workshoprest.model.DTO.LoanDto;
import com.example.workshoprest.services.LoanService;
import org.apache.coyote.Response;
import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoanController {

    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }


    @GetMapping("/api/v1/loan/{loanId}")
    public ResponseEntity<LoanDto> findById(@PathVariable("loanId") String loanId){
        LoanDto loan = loanService.findById(loanId);
        return ResponseEntity.ok().body(loan);
    }

    @GetMapping("/api/v1/loans")
    public ResponseEntity<List<LoanDto>> findAll(){
        List<LoanDto> loan = loanService.findAll();
        return ResponseEntity.ok().body(loan);
    }

    @PostMapping("/api/v1/loan/create")
    public ResponseEntity<LoanDto> create(@RequestBody LoanDto loanDto){
        LoanDto loan = loanService.create(loanDto);
        return ResponseEntity.ok().body(loan);
    }


    @PutMapping("/api/v1/loan/update")
    public ResponseEntity<LoanDto> update(@RequestBody LoanDto loanDto){
        LoanDto loan = loanService.update(loanDto);
        return ResponseEntity.ok().body(loan);
    }
}
