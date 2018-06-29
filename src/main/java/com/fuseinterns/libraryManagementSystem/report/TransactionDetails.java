package com.fuseinterns.libraryManagementSystem.report;

import com.fuseinterns.libraryManagementSystem.borrower.Borrow;
import com.fuseinterns.libraryManagementSystem.borrower.Return;

import java.util.List;

public class TransactionDetails {

    private List<Borrow> issues;
    private List<Return> returns;

    private int totalIssues;
    private int totalReturns;
    private int totalTransactions;
    public TransactionDetails(List<Borrow> issues, List<Return> returns) {
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

    public List<Return> getReturns() {
        return returns;
    }

    public int getTotalIssues() {
        return totalIssues;
    }


}
