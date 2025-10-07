package banking_application.SpringBoot_Banking_application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Accountdto {
    private Long id;
    private String accountHolderNumber;
    private double balance;

}
