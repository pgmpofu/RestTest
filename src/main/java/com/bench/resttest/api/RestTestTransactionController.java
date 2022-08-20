package com.bench.resttest.api;

import com.bench.resttest.model.RestTestTransaction;
import com.bench.resttest.service.RestTestTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class RestTestTransactionController {

    @Autowired
    private RestTestTransactionService service;
    @GetMapping("/all")
    public ResponseEntity listTransactions() {
        return ResponseEntity.ok(service.listTransactions());
    }

    @GetMapping("/totalByDay")
    public ResponseEntity totalByDay(@RequestBody final String date) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/runningTotal")
    public ResponseEntity runningTotal(@RequestBody final RestTestTransaction request){
        return ResponseEntity.ok().build();
    }
}
