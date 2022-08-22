package com.bench.resttest.service;

import com.bench.resttest.model.RestTestTransaction;
import com.bench.resttest.model.RestTestTransactionRunningTotal;
import com.bench.resttest.repository.RestTestTransactionRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class RestTestTransactionServiceTest {

    private RestTestTransaction t1;
    private RestTestTransaction t2;
    private RestTestTransaction t3;
    private RestTestTransaction t4;

    @Autowired
    private RestTestTransactionService service;

    @Autowired
    private RestTestTransactionRepository repository;


    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        repository.deleteAll();
    }

    @AfterEach
    public void cleanUp() {
        repository.deleteAll();
    }

    @Test
    void getTotalByDay() {
        repository.save(new RestTestTransaction("Test 1", "Expense 1", BigDecimal.valueOf(-35.7), LocalDate.now()));
        repository.save(new RestTestTransaction("Test 2", "Expense 2", BigDecimal.valueOf(25.0), LocalDate.now()));
        repository.save(new RestTestTransaction("Test 3", "Expense 3", BigDecimal.valueOf(58.3), LocalDate.now()));
        repository.save(new RestTestTransaction("Test 4", "Expense 4", BigDecimal.valueOf(-89.4), LocalDate.now()));
        BigDecimal total = service.getTotalByDay(LocalDate.now());
        assertTrue(total != null, "Total value cannot be null");
        assertEquals(BigDecimal.valueOf(-41.80).doubleValue(), total.doubleValue(), "Total by day for this date is incorrect");
    }

    @Test
    void getRunningTotal() {
        repository.save(new RestTestTransaction("Test 5", "Expense 5", BigDecimal.valueOf(8), LocalDate.now().plusDays(1)));
        repository.save(new RestTestTransaction("Test 6", "Expense 6", BigDecimal.valueOf(124), LocalDate.now().plusDays(1)));
        repository.save(new RestTestTransaction("Test 7", "Expense 7", BigDecimal.valueOf(-66.6), LocalDate.now().plusDays(2)));
        repository.save(new RestTestTransaction("Test 8", "Expense 8", BigDecimal.valueOf(-35.1), LocalDate.now().plusDays(2)));

        List<RestTestTransactionRunningTotal> totals = service.getRunningTotal();
        assertTrue(!CollectionUtils.isEmpty(totals), "No running totals found");
        for(RestTestTransactionRunningTotal total : totals) {
            if(LocalDate.now().plusDays(1).equals(total.getDate())) {
                assertTrue(total.getTotal().intValue() == 132);
            }

            if(LocalDate.now().plusDays(2).equals(total.getDate())) {
                assertTrue(total.getTotal().doubleValue() == -101.7);
            }
        }
    }
}