package banking_application.SpringBoot_Banking_application.Mapper;

import banking_application.SpringBoot_Banking_application.Entity.Account;
import banking_application.SpringBoot_Banking_application.dto.Accountdto;

public class AccountMapper {
    public static Account maptoAccount(Accountdto accountdto){
        Account account = new Account(
               accountdto.getId(),
               accountdto.getAccountHolderNumber(),
               accountdto.getBalance()
        );
        return account;
    }

    public static Accountdto maptoAccountdto(Account account){

        Accountdto accountdto = new Accountdto(
                account.getId(),
                account.getAccountHolderNumber(),
                account.getBalance()
        );
        return accountdto;
    }
}
