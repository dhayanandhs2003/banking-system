package Task9;

// BankAccount.java
public abstract class BankAccount {
    protected String accountNumber;
    protected String customerName;
    protected double balance;

    public BankAccount() {
        this.accountNumber = "Unknown";
        this.customerName = "Unknown";
        this.balance = 0.0;
    }

    public BankAccount(String accountNumber, String customerName, double balance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getCustomerName() { return customerName; }
    public double getBalance() { return balance; }

    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public void setBalance(double balance) { this.balance = balance; }

    public void printAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Balance: " + balance);
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    public abstract void calculateInterest();
}
