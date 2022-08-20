package com.bench.resttest.repository;

import com.bench.resttest.model.RestTestTransaction;
import org.springframework.data.repository.CrudRepository;

public interface RestTestTransactionRepository extends CrudRepository<RestTestTransaction, Long> {

}
