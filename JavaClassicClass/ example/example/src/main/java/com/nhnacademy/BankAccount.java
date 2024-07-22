package com.nhnacademy;

import java.math.BigDecimal;

public class BankAccount {
    // 캡슗화
    // public -> private로 변경시 Test에서 설정이 안된다
    public String name;
    public int accountNo;
    public int balance = 100;         // int -> balance => 아무런 이상 없음
                                // -> BigDecimal 사용 => 모두 BigDecimal에 맞춰서 수정 해야한다
                                // BigDecimal로 변경 시 amount가 다른 종류일 경우 그에 맞춰 변환해줘야한다 ex. (BigDecimal)

    public static int interest = 5;

    public void withdraw(Number amount) {
        /*if (this.balance.compareTo((BigDecimal) amount) > 0) {
            return ;
        }
        else {
            this.balance.subtract((BigDecimal) amount);
        }*/
    }

    public int getInterest() {
        return balance * interest;
    }
}

class Test {
    public static void main(String[] args) {
//        BankAccount account = new BankAccount();    //  = 기준 뒤는 생성자
//        account.accountNo = 1;
//        account.name = "Celine";
//        account.balance = 100000000;
//
//        account.withdraw(1000);
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();
        BankAccount account3 = new BankAccount();

        BankAccount.interest = 7;
        System.out.println(account1.getInterest());
        System.out.println(account2.getInterest());
        System.out.println(account3.getInterest());
    }
}