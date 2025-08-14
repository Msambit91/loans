package com.sambit.loans.controller;

import com.sambit.loans.constants.LoansConstants;
import com.sambit.loans.dto.LoansDto;
import com.sambit.loans.dto.ResponseDto;
import com.sambit.loans.service.ILoansService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class LoansController {

    private ILoansService loansService;

    @PostMapping("/loans")
    public ResponseEntity<ResponseDto> createLoan(@RequestBody LoansDto requestDto) {
        loansService.createLoan(requestDto.getMobileNumber());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(LoansConstants.STATUS_201, LoansConstants.MESSAGE_201));
    }
}
