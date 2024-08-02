package factory;

import account.Account;
import account.BankAccount;

// 추상 클래스로 역할은 BankAccountFactory에서의 메소드를 선언만 한다
public abstract class AccountFactory {
    Account account;

    public AccountFactory(Account account) {
        this.account = account;
    }

    public abstract boolean checkInformation(Account account);
    public abstract boolean checkService(Account account);
    public abstract int getBalance(Account account);
    public abstract boolean validate(Account account);
    public abstract BankAccount createAccount(Account account);

    public Account geAccount() {
        this.checkInformation(this.account);
        this.checkService(account);
        this.getBalance(account);
        this.validate(account);
        return createAccount(account);
    }
}
