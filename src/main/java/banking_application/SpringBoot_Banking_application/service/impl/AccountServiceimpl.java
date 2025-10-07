package banking_application.SpringBoot_Banking_application.service.impl;

import banking_application.SpringBoot_Banking_application.Entity.Account;
import banking_application.SpringBoot_Banking_application.Mapper.AccountMapper;
import banking_application.SpringBoot_Banking_application.dto.Accountdto;
import banking_application.SpringBoot_Banking_application.repository.AccountRepo;
import banking_application.SpringBoot_Banking_application.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceimpl implements AccountService {

    private AccountRepo accountRepo;

    public AccountServiceimpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    public Accountdto createAccount(Accountdto accountdto) {
        Account account = AccountMapper.maptoAccount(accountdto);
        Account savedAccount = accountRepo.save(account);
        return AccountMapper.maptoAccountdto(savedAccount);
    }

    @Override
    public Accountdto getAccountById(Long id) {
        Account account= accountRepo.findById(id).orElseThrow(()-> new RuntimeException("Account not found"));
        return AccountMapper.maptoAccountdto(account);
    }

    @Override
    public Accountdto deposite(Long id, double amount) {
        Account account= accountRepo.findById(id).orElseThrow(()-> new RuntimeException("Account not found"));
        double total = account.getBalance()+amount;
        account.setBalance(total);
        Account savedAccount = accountRepo.save(account);
        return AccountMapper.maptoAccountdto(savedAccount);
    }

    @Override
    public Accountdto withdrawal(Long id, double amount) {
        Account account = accountRepo.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient amount");
        }
        double total = account.getBalance() - amount;
        account.setBalance(total);
        Account savedAccount = accountRepo.save(account);
        return AccountMapper.maptoAccountdto(savedAccount);
    }


}
