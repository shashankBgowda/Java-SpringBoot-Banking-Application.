package banking_application.SpringBoot_Banking_application.controller;

import banking_application.SpringBoot_Banking_application.Entity.Account;
import banking_application.SpringBoot_Banking_application.dto.Accountdto;
import banking_application.SpringBoot_Banking_application.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //Add account REST-API
    @PostMapping
    public ResponseEntity<Accountdto> addAccount(@RequestBody Accountdto accountdto){
        return new ResponseEntity<>(accountService.createAccount(accountdto), HttpStatus.CREATED);
    }

    //Get Account REST-API
    @GetMapping("/{id}")
    public ResponseEntity<Accountdto> getAccountById(@PathVariable Long id){
        Accountdto accountdto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountdto);
    }

    //Deposite Rest-API
    @PutMapping("/{id}/deposite")
    public ResponseEntity<Accountdto> deposite(@PathVariable Long id,
                                              @RequestBody Map<String, Double> request) {
        Accountdto accountdto=accountService.deposite(id, request.get("amount"));
        return ResponseEntity.ok(accountdto);
    }

    //Withdraw REST-API
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<Accountdto> withdrawal(@PathVariable Long id, @RequestBody Map<String, Double> request){
        double amount = request.get("amount");
        Accountdto accountdto = accountService.withdrawal(id, amount);
        return ResponseEntity.ok(accountdto);
    }

    //Get all account REST-API
    public ResponseEntity<List<Accountdto>> getAllAccounts(){
        List<Accountdto> account = accountService.getAllAccounts();
        return ResponseEntity.ok(account);
    }
}

