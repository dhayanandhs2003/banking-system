package Task7;

// Account.java
public class Account {
    private long accountNumber;
    private String accountType;
    private double balance;

    // Default Constructor
    public Account() {
        this.accountNumber = 0;
        this.accountType = "Unknown";
        this.balance = 0.0;
    }

    // Parameterized Constructor
    public Account(long accountNumber, String accountType, double balance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }

    // Getters and Setters
    public long getAccountNumber() { return accountNumber; }
    public void setAccountNumber(long accountNumber) { this.accountNumber = accountNumber; }

    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    // Deposit Method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Withdraw Method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    // Interest Calculation (4.5%)
    public void calculateInterest() {
        if (accountType.equalsIgnoreCase("Savings")) {
            double interest = (balance * 4.5) / 100;
            balance += interest;
            System.out.println("Interest added: " + interest);
        } else {
            System.out.println("Interest applies only to Savings accounts.");
        }
    }

    // Print Account Details
    public void printAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: " + balance);
    }
}
