package com.bench.resttest.service;

import com.bench.resttest.model.RestTestTransaction;
import com.bench.resttest.model.RestTestTransactionRequest;
import com.bench.resttest.model.RestTestTransactionRunningTotal;
import com.bench.resttest.repository.RestTestTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class RestTestTransactionService {

    @Autowired
    private RestTestTransactionRepository restTestTransactionRepository;

    public RestTestTransactionRequest listTransactions(Long pageNumber) throws Exception {
        Long totalCount = restTestTransactionRepository.count();

        if (totalCount == null || totalCount == 0) {
            throw new Exception("No transactions found");
        }
        Pageable pageable = PageRequest.of(pageNumber.intValue(), totalCount.intValue());
        Iterable<RestTestTransaction> transactions = restTestTransactionRepository.findAll(pageable);

        List<RestTestTransaction> transactionList = new ArrayList<>();
        for (RestTestTransaction transaction : transactions) {
            transactionList.add(transaction);
        }

        RestTestTransactionRequest request = new RestTestTransactionRequest();
        request.setTotalCount(totalCount);
        request.setPageNumber(pageNumber);
        request.setTransactions(transactionList);
        return request;
    }

    public BigDecimal getTotalByDay(LocalDate date) {
        return restTestTransactionRepository.findTotalByDay(date);
    }

    public List<RestTestTransactionRunningTotal> getRunningTotal() {
        return restTestTransactionRepository.findRunningTotals();
    }
}
