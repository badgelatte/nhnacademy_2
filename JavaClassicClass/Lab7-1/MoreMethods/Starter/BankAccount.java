import java.math.*;
import java.util.Scanner;

public class BankAccount {
    private long accountNumber;
    private String ownerName;
    private BigDecimal balance;

    private static long nextAccountNumber;

    private static long nextNumber() {
        return nextAccountNumber++;
    }

    public void setData(String ownerName, BigDecimal balance) {
        this.accountNumber = nextNumber();
        this.ownerName = ownerName;
        this.balance = balance;
    }
        
    public long getNumber() {
        return this.accountNumber;
    }
        
    public String getOwnerName() {
        return this.ownerName;
    }
        
    public BigDecimal getBalance() {
        return this.balance;
    }

    //
    // add deposit method here.
    //
    
    //예금
    public BigDecimal deposit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
        return balance;
    }
    
    //
    // add withDraw method here.
    //

    // 출금
    public boolean withDraw(BigDecimal amount) {
        // A.compareTo(B) -> A < B = -1  /  A = B = 0
        if(this.balance.compareTo(amount) == -1 || this.balance.compareTo(amount) == 0){
            return false;
        }
        // A.compareTo(B) -> A > B = 1
        else {
            this.balance = this.balance.subtract(amount);
            return true;
        }
    }
}

class CreateAccount {
    public static BankAccount createNewBankAccount(String ownerName, BigDecimal balance) {
        BankAccount newAccount = new BankAccount();
        newAccount.setData(ownerName, balance);

        return newAccount;
    }

    //
    // add testDeposit method here.
    //


    //
    // add testWithdraw method here.
    //

    public static void main(String[] args) {
        BankAccount bankAccount = CreateAccount.createNewBankAccount("Vesper Lind", new BigDecimal("0.0"));
        printBankAccount(bankAccount);
        BankAccount bankAccount2 = CreateAccount.createNewBankAccount("Celine ", new BigDecimal("0.0"));
        printBankAccount(bankAccount2);

        bankAccount.deposit(new BigDecimal(100));
        printBankAccount(bankAccount);
        bankAccount.withDraw(new BigDecimal(50));
        printBankAccount(bankAccount);
    }

    public static void printBankAccount(BankAccount account) {
        System.out.println("Account Number: " + account.getNumber());
        System.out.println("Owner Name: " + account.getOwnerName());
        System.out.println("Balance: " + account.getBalance() + "\n");
    }
}