package com.bench.resttest.api;

import com.bench.resttest.model.RestTestTransaction;
import com.bench.resttest.service.RestTestTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/transactions")
public class RestTestTransactionController {

    @Autowired
    private RestTestTransactionService service;
    @GetMapping(value = "/{page}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity listTransactions(@PathVariable final Long page) throws Exception {
        if(page == null) {
            throw new NullPointerException("Page number must be informed");
        }
        return ResponseEntity.ok(service.listTransactions(page));
    }

    @GetMapping("/totalByDay")
    public ResponseEntity totalByDay(@RequestBody final RestTestTransaction restTestTransaction) {
        if(restTestTransaction == null) {
            throw new NullPointerException("Transaction information must be informed");
        }

        if(restTestTransaction.getDate() == null) {
            throw new NullPointerException("Date must be informed");
        }

        return ResponseEntity.ok(service.getTotalByDay(restTestTransaction.getDate()));
    }

    @GetMapping("/runningTotal")
    public ResponseEntity runningTotal(){
        return ResponseEntity.ok(service.getRunningTotal());
    }
}
