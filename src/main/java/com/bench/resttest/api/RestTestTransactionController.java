package com.bench.resttest.api;

import com.bench.resttest.model.RestTestTransaction;
import com.bench.resttest.service.RestTestTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/transactions")
public class RestTestTransactionController {

    @Autowired
    private RestTestTransactionService service;
    @GetMapping(value = "/{page}")
    public ResponseEntity listTransactions(@PathVariable final Long page) throws Exception {
        if(page == null) {
            throw new NullPointerException("Page number cannot be null");
        }
        return ResponseEntity.ok(service.listTransactions(page));
    }

    @GetMapping("/totalByDay")
    public ResponseEntity totalByDay(@RequestBody final RestTestTransaction restTestTransaction) {
        return ResponseEntity.ok(service.getTotalByDay(restTestTransaction.getDate()));
    }

    @GetMapping("/runningTotal")
    public ResponseEntity runningTotal(@RequestBody final RestTestTransaction request){
        return ResponseEntity.ok().build();
    }
}
