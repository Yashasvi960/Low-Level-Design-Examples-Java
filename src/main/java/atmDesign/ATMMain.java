package atmDesign;

public class ATMMain {

    public static void main(String args[]) {
        Account account = new Account("123456789", 1000.0);
        Account account1 = new Account("987654321", 500.0);

        ATM atm = new ATM();
        atm.addAccount(account);
        atm.addAccount(account1);

        System.out.println("Initial Balance of Account 123456789: " + atm.checkBalance(account));
        System.out.println("Initial Balance of Account 987654321: " + atm.checkBalance(account1));

        atm.depositAmount("123456789", 200.0);
        atm.depositAmount("987654321", 100.0);

        System.out.println("Balance of Account 123456789 after deposit: " + atm.checkBalance(account));
        System.out.println("Balance of Account 987654321 after deposit: " + atm.checkBalance(account1));

        atm.withdrawAmount("123456789", 150.0);
        atm.withdrawAmount("987654321", 50.0);

        System.out.println("Balance of Account 123456789 after withdrawal: " + atm.checkBalance(account));
        System.out.println("Balance of Account 987654321 after withdrawal: " + atm.checkBalance(account1));
    }
}
