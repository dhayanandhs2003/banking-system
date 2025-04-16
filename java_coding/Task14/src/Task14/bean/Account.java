package Task14.bean;

public abstract class Account {
    private long accountNumber;
    private float balance;

    public Account(long accountNumber, float balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public abstract String getAccountType();
}