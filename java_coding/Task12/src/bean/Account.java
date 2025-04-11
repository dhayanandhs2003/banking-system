package Task12.src.bean;

public abstract class Account {
    private static long counter = 1000;
    protected long accountNumber;
    protected String type;
    protected float balance;
    protected Customer customer;

    public Account(String type, float balance, Customer customer) {
        this.accountNumber = counter++;
        this.type = type;
        this.balance = balance;
        this.customer = customer;
    }

    public long getAccountNumber() { return accountNumber; }
    public float getBalance() { return balance; }
    public void setBalance(float balance) { this.balance = balance; }
    public Customer getCustomer() { return customer; }

    public String toString() {
        return "Account No: " + accountNumber + ", Type: " + type + ", Balance: " + balance + ", " + customer;
    }
}