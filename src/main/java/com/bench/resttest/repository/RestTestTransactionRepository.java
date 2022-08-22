package com.bench.resttest.repository;

import com.bench.resttest.model.RestTestTransaction;
import com.bench.resttest.model.RestTestTransactionRunningTotal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface RestTestTransactionRepository extends PagingAndSortingRepository<RestTestTransaction, Long> {

    @Query("SELECT SUM(amount) FROM RestTestTransaction WHERE date = :date")
    BigDecimal findTotalByDay(LocalDate date);

    @Query(value = "SELECT new com.bench.resttest.model.RestTestTransactionRunningTotal(r.date, SUM(amount) AS total) FROM RestTestTransaction r GROUP BY date")
    List<RestTestTransactionRunningTotal> findRunningTotals();;
}
