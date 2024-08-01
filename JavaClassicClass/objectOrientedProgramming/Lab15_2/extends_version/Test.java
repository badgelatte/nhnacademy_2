package Lab15_2.extends_version;

import java.math.BigDecimal;

class Test {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Jason", new BigDecimal(100));
        account.printAccount();
        BankAccount account2 = new LimitedBankAccount("James", new BigDecimal(1000), new BigDecimal(100));
        account2.printAccount();
        account2.deposit(new BigDecimal("1000"));
    }
}