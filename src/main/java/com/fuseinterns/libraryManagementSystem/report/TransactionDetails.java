package com.fuseinterns.libraryManagementSystem.report;

import com.fuseinterns.libraryManagementSystem.borrower.Borrow;

import java.util.List;

public class TransactionDetails {

    private List<Borrow> issues;
    private List<Borrow> returns;

    private int totalIssues;
    private int totalReturns;
    private int totalTransactions;
    public TransactionDetails(List<Borrow> issues, List<Borrow> returns) {
        this.issues = issues;
        this.totalIssues = issues.size();
        this.returns = returns;
        this.totalReturns = returns.size();
        this.totalTransactions = totalIssues+totalReturns;

    }

    public int getTotalTransactions() {
        return totalTransactions;
    }

    public int getTotalReturns() {
        return totalReturns;
    }

    public List<Borrow> getIssues() {
        return issues;
    }

    public List<Borrow> getReturns() {
        return returns;
    }

    public int getTotalIssues() {
        return totalIssues;
    }


}
