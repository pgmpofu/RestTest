package com.bench.resttest.model;

import java.util.List;

public class RestTestTransactionRequest {

    private Long totalCount;
    private Long pageNumber;
    private List<RestTestTransaction> transactions;

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public void setPageNumber(Long pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setTransactions(List<RestTestTransaction> transactions) {
        this.transactions = transactions;
    }
}
