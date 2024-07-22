public class Bank{
    class Account {
        private int accountNo;
        private Customer customerName;

        void getNumber() {
            NumberGenerator gen = new NumberGenerator();
        }

        class Customer{
            private int customerNo;
            private String name;
            private String gender;
        }

        private class NumberGenerator{

        }
    }

    public static void main(String[] args) {
        Bank.Account account = new Bank.Account();
        Bank.NumberGenerator generator = new Bank.Generator();
    }
}