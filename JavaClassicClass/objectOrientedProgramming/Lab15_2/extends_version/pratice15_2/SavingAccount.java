package Lab15_2.extends_version.pratice15_2;

import java.math.BigDecimal;

import Lab15_2.extends_version.BankAccount;

public class SavingAccount extends BankAccount{

    public SavingAccount(String ownerName, BigDecimal balance) {
        super(ownerName, balance);
    }
    
    public BigDecimal deposit(BigDecimal amount) {
        BigDecimal balance = getBalance();

        balance = balance.add(balance);
        super.setBalance(balance);
        return balance;
    }

}
