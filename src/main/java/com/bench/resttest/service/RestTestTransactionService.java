package com.bench.resttest.service;

import com.bench.resttest.model.RestTestTransaction;
import com.bench.resttest.repository.RestTestTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestTestTransactionService {

    @Autowired
    private RestTestTransactionRepository restTestTransactionRepository;

    public Iterable<RestTestTransaction> listTransactions() {
        return restTestTransactionRepository.findAll();
    }

}
