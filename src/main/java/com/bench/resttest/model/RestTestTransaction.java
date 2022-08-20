package com.bench.resttest.model;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public record RestTestTransaction (String companyName, String ledger, BigDecimal amount,  LocalDate date) {
}
