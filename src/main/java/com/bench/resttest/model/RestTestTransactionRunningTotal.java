package com.bench.resttest.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RestTestTransactionRunningTotal {
    private LocalDate date;
    private BigDecimal total;

    public RestTestTransactionRunningTotal() {
    }

    public RestTestTransactionRunningTotal(LocalDate date, BigDecimal total) {
        this.date = date;
        this.total = total;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
