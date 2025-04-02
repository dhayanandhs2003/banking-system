package Task10;

public class Account {
    private static long accountCounter = 1000; // Auto-increment from 1001
    private long accountNumber;
    private String accountType;
    private float balance;
    private Customer customer;

    public Account(Customer customer, String accountType, float balance) {
        this.accountNumber = ++accountCounter;
        this.accountType = accountType;
        this.balance = balance;
        this.customer = customer;
    }

    public long getAccountNumber() { return accountNumber; }
    public String getAccountType() { return accountType; }
    public float getBalance() { return balance; }
    public Customer getCustomer() { return customer; }

    public void deposit(float amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean withdraw(float amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        System.out.println("Insufficient balance or invalid amount.");
        return false;
    }

    public void printAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: $" + balance);
        customer.printCustomerDetails();
    }
}
