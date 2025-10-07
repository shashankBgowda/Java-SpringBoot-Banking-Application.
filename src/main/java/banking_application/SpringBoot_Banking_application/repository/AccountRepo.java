package banking_application.SpringBoot_Banking_application.repository;

import banking_application.SpringBoot_Banking_application.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Long> {

}
