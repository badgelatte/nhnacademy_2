package practice;

import java.math.BigDecimal;

public class BankAccount {
    private String accountNumber;
    private String ownerName;
    private BigDecimal balance;

    public BankAccount(String ownerName, BigDecimal balance){
        this.accountNumber = CreateAccount.createAccountNumber();
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public BigDecimal deposit(BigDecimal amount) {
        this.balance = balance.add(amount);
        return balance;
    }

    public boolean withdraw(BigDecimal amount){
        if (balance.compareTo(amount) == 1 || balance.compareTo(amount) == 0) {
            return true;
        } 
        balance = balance.subtract(amount);
        return false;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}