package Lab15_1.practice;

public class PrintAccount{
    public void printAccount(BankAccount account) {
        System.out.println("Account Num: " + account.getAccountNumber());
        System.out.println("Onwer Name: " + account.getOwnerName());
        System.out.println("Balance: " + account.getBalance());
    }
}
