package Lab15_1;

import java.math.*;

public class BankAccount {
    private String accountNumber;
    private String ownerName;
    private BigDecimal balance;

    public BankAccount() {
        this.accountNumber = CreateAccount.createAccountNumber();
        this.ownerName = "Unknown";
        this.balance = new BigDecimal("0");
    }

    public BankAccount(String ownerName, BigDecimal balance) {
        this.accountNumber = CreateAccount.createAccountNumber();
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public String getAccountNo() {
        return this.accountNumber;
    }
        
    public String getOwnerName() {
        return this.ownerName;
    }
        
    public BigDecimal getBalance() {
        return this.balance;
    } 

    public BigDecimal deposit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
        return this.balance;
    }

    public boolean withDraw(BigDecimal amount) {
        if (amount.compareTo(this.balance) == 1 || amount.compareTo(this.balance) == 0) {
            return false;
        }
        else {
            balance = balance.subtract(amount);
            return true;
        }
    }

    public void printAccount() {
        PrintAccount.printAccount(this);
    }
}