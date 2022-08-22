package com.bench.resttest.repository;

import com.bench.resttest.model.RestTestTransaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface RestTestTransactionRepository extends PagingAndSortingRepository<RestTestTransaction, Long> {

    @Query("SELECT sum(amount) FROM RestTestTransaction WHERE date = :date")
    BigDecimal findTotalByDay(LocalDate date);
}
