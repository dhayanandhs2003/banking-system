package Task11.src.bean;

public abstract class Account {
    protected long accountNumber;
    protected String accountType;
    protected float balance;
    protected Customer customer;
    protected static long lastAccNo = 1000;

    public Account(String accountType, float balance, Customer customer) {
        this.accountNumber = ++lastAccNo;
        this.accountType = accountType;
        this.balance = balance;
        this.customer = customer;
    }

    public long getAccountNumber() { return accountNumber; }
    public String getAccountType() { return accountType; }
    public float getBalance() { return balance; }
    public void setBalance(float balance) { this.balance = balance; }
    public Customer getCustomer() { return customer; }

    @Override
    public String toString() {
        return "Account No: " + accountNumber + ", Type: " + accountType + ", Balance: " + balance + "\nCustomer: " + customer;
    }
}

