package com.sambit.loans.mapper;

import com.sambit.loans.dto.LoansDto;
import com.sambit.loans.entity.Loans;

public class LoansMapper {
    public static LoansDto mapToLoansDto(Loans loans){
        LoansDto loansDto = new LoansDto();
        loansDto.setLoanNumber(loans.getLoanNumber());
        loansDto.setLoanType(loans.getLoanType());
        loansDto.setTotalLoan(loans.getTotalLoan());
        loansDto.setAmountPaid(loans.getAmountPaid());
        loansDto.setOutstandingAmount(loans.getOutstandingAmount());
        loansDto.setMobileNumber(loans.getMobileNumber());
        return loansDto;
    }
    public static Loans mapToLoans(LoansDto loansDto){
        Loans loans = new Loans();
        loans.setLoanType(loansDto.getLoanType());
        loans.setTotalLoan(loansDto.getTotalLoan());
        loans.setAmountPaid(loansDto.getAmountPaid());
        loans.setOutstandingAmount(loansDto.getOutstandingAmount());
        loans.setMobileNumber(loansDto.getMobileNumber());
        loans.setLoanNumber(loansDto.getLoanNumber());
        return loans;
    }
}
