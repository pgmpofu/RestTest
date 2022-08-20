package api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class RestTestTransactionController {

    @GetMapping
    public ResponseEntity listTransactions() {
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/totalByDay")
    public ResponseEntity totalByDay(@RequestBody final String date) {
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/runningTotal")
    public ResponseEntity runningTotal(@RequestBody final TransactionRequest request){
        return ResponseEntity.ok().build();
    }
}
