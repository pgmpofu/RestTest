package com.bench.resttest.model;

import java.util.List;

public class RestTestTransactionRequest {

    private Long totalCount;
    private Long pageNumber;
    private List<RestTestTransaction> transactions;

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Long getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Long pageNumber) {
        this.pageNumber = pageNumber;
    }

    public List<RestTestTransaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<RestTestTransaction> transactions) {
        this.transactions = transactions;
    }
}
