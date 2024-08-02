package factory;

import account.Account;
import account.BankAccount;

// 팩토리 메소드 패턴 구조 사진 중 ConcreteCreator 역할을한다
public class BankAccountFactory extends AccountFactory{

    public BankAccountFactory(Account account) {
        super(account);
    }

    public boolean checkInformation(Account account) {
        return true;
    }

    public boolean checkService(Account account) {
        return true;
    }

    public int getBalance(Account account) {
        return 0;
    }

    public boolean validate(Account account) {
        return true;
    }

    public BankAccount createAccount(Account account) {
        boolean isInfo = this.checkInformation(account);
        boolean isService = this.checkService(account);
        int balance = this.getBalance(account);
        boolean isValid = this.validate(account);

        if(isInfo && isService && isValid) {
            return new BankAccount();
        }
        else {
            return null;
        }
    }
}
