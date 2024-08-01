package Lab15_1;

public class PrintAccount {
    public static void printAccount(BankAccount account) {
        System.out.println("Account Number: " + account.getAccountNo());
        System.out.println("Owner Name: " + account.getOwnerName());
        System.out.println("Balance: " + account.getBalance());
    }
}
