import java.util.Scanner;

// Base Account Class
abstract class Account {
    protected int accountNumber;
    protected double balance;
    
    public Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    
    public abstract void withdraw(double amount);
    public abstract void calculateInterest();
    
    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

// Savings Account
class SavingsAccount extends Account {
    private double interestRate;
    
    public SavingsAccount(int accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }
    
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
    
    @Override
    public void calculateInterest() {
        double interest = balance * (interestRate / 100);
        balance += interest;
        System.out.println("Interest added: " + interest);
    }
}

// Current Account
class CurrentAccount extends Account {
    private static final double OVERDRAFT_LIMIT = 5000;
    
    public CurrentAccount(int accountNumber, double balance) {
        super(accountNumber, balance);
    }
    
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= -OVERDRAFT_LIMIT) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Overdraft limit exceeded.");
        }
    }
    
    @Override
    public void calculateInterest() {
        System.out.println("No interest for Current Account.");
    }
}

// Bank class to handle user interactions
public class Task8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = null;
        
        System.out.println("Choose Account Type: \n1. Savings Account\n2. Current Account");
        int choice = scanner.nextInt();
        
        System.out.print("Enter Account Number: ");
        int accountNumber = scanner.nextInt();
        
        System.out.print("Enter Initial Balance: ");
        double balance = scanner.nextDouble();
        
        switch (choice) {
            case 1:
                System.out.print("Enter Interest Rate: ");
                double interestRate = scanner.nextDouble();
                account = new SavingsAccount(accountNumber, balance, interestRate);
                break;
            case 2:
                account = new CurrentAccount(accountNumber, balance);
                break;
            default:
                System.out.println("Invalid choice.");
                System.exit(0);
        }
        
        while (true) {
            System.out.println("\n1. Deposit\n2. Withdraw\n3. Calculate Interest\n4. Display Balance\n5. Exit");
            System.out.print("Enter choice: ");
            int option = scanner.nextInt();
            
            switch (option) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.calculateInterest();
                    break;
                case 4:
                    account.displayBalance();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you for banking with us!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }
}
