package com.bench.resttest.service;

import com.bench.resttest.model.RestTestTransaction;
import com.bench.resttest.repository.RestTestTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class RestTestTransactionService {

    @Autowired
    private final RestTestTransactionRepository repository;

    public RestTestTransactionService(RestTestTransactionRepository repository) {
        this.repository = repository;
    }

    public List<RestTestTransaction> listTransactions() {
        return repository.findAll();
    }

}