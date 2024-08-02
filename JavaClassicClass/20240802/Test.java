import account.BankAccount;
import factory.AccountFactory;
import factory.BankAccountFactory;

public class Test {
    public static void main(String[] args) {
        BankAccount b = new BankAccount();

        AccountFactory f = new BankAccountFactory(b);
        BankAccount account = (BankAccount)f.geAccount();

    }
}
