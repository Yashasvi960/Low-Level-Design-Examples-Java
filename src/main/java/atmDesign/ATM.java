package atmDesign;

import java.util.HashMap;
import java.util.Map;

public class ATM {

    private Map<String, Account> accounts;
    public ATM() {
        this.accounts = new HashMap<>();
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public void depositAmount(String accountNumber, Double amount) {
        Account account = accounts.get(accountNumber);
       if(account==null) {
           throw new IllegalArgumentException("Account is not available");
       }
       account.deposit(amount);
    }

    public void withdrawAmount(String accountNumber, Double amount) {
        Account account = accounts.get(accountNumber);
        if(account==null) {
            throw new IllegalArgumentException("Account is not available");
        }
        account.withdraw(amount);
    }

    public Double checkBalance(Account account) {
        if(account==null) {
            throw new IllegalArgumentException("Account is not available");
        }

        return account.getBalance();
    }

}
