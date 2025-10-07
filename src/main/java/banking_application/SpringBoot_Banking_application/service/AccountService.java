package banking_application.SpringBoot_Banking_application.service;

import banking_application.SpringBoot_Banking_application.Entity.Account;
import banking_application.SpringBoot_Banking_application.dto.Accountdto;

public interface AccountService {
    Accountdto createAccount(Accountdto account);
    Accountdto getAccountById(Long id);
    Accountdto deposite(Long id, double amount);
    Accountdto withdrawal(Long id, double amount);
}
