package com.sambit.loans.service;

public interface ILoansService {
    /**
     * Create Loan
     * @param mobileNumber - Mobile Number of the customer
     */
    void createLoan(String mobileNumber);
}
