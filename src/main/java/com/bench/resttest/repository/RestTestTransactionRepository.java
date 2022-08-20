package com.bench.resttest.repository;

import com.bench.resttest.model.RestTestTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestTestTransactionRepository extends JpaRepository<RestTestTransaction, Long> {

}
