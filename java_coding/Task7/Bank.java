package Task7;


// Bank.java
import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a Customer
        Customer customer = new Customer(101, "John", "Doe", "john.doe@example.com", "9876543210", "New York");
        System.out.println("\nCustomer Details:");
        customer.printCustomerInfo();

        // Create an Account
        Account account = new Account(123456789, "Savings", 5000);
        System.out.println("\nAccount Details:");
        account.printAccountInfo();

        // Deposit Operation
        System.out.print("\nEnter deposit amount: ");
        double depositAmount = scanner.nextDouble();
        account.deposit(depositAmount);
        account.printAccountInfo();

        // Withdraw Operation
        System.out.print("\nEnter withdrawal amount: ");
        double withdrawAmount = scanner.nextDouble();
        account.withdraw(withdrawAmount);
        account.printAccountInfo();

        // Calculate Interest (for Savings Account)
        account.calculateInterest();
        account.printAccountInfo();

        scanner.close();
    }
}

