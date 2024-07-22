import java.math.*;

public class BankAccount {
    // 캡슐화
    private long accountNumber;
    private String ownerName;
    private BigDecimal balance;

    //
    // add setData method here.
    public void setData(long accountNumber, String ownerName, BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    //
    // add getNumber method here.
    public long getNumber() {
        return this.accountNumber;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }
    

}

class CreateAccount {
    public static BankAccount createNewBankAccount(long accountNumber, String ownerName, BigDecimal balance) {
        BankAccount newAccount = new BankAccount();
        
        // newAccount.accountNumber = accountNumber;
        // newAccount.ownerName = ownerName;
        // newAccount.balance = balance;
        newAccount.setData(accountNumber, ownerName, balance);

        return newAccount;
    }

    //public static void main(String[] args) {
    //    BankAccount bankAccount = CreateAccount.createNewBankAccount(1, "Vesper Lind", new BigDecimal("0.0"));
    //    printBankAccount(bankAccount);
    //}

    public static void printBankAccount(BankAccount account) {
        // System.out.println("Account Number: " + account.accountNumber);
        // System.out.println("Owner Name: " + account.ownerName);
        // System.out.println("Balance: " + account.balance);
        System.out.println("Account Number: " + account.getNumber());
        System.out.println("Owner Name: " + account.getOwnerName());
        System.out.println("Balance: " + account.getBalance());
    }
}