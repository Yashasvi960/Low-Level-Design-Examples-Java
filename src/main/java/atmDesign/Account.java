package atmDesign;

public class Account {

    private String accountNumber;
    private Double balance;

    public Account(String accountNumber, Double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    public void deposit(Double amount) {
        if(amount<=0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }

        balance+=amount;
    }

    public void withdraw(Double amount) {
        if(amount<=0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if(amount>balance) {
            throw new IllegalArgumentException("Insufficient balance for withdrawal");
        }

        balance-=amount;
    }

}
