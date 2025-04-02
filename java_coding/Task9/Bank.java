package Task9;


// Bank.java
import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = null;

        System.out.println("Choose account type to create:");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        int choice = scanner.nextInt();

        scanner.nextLine();
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance = scanner.nextDouble();

        switch (choice) {
            case 1:
                System.out.print("Enter Interest Rate: ");
                double interestRate = scanner.nextDouble();
                account = new SavingsAccount(accountNumber, customerName, balance, interestRate);
                break;
            case 2:
                account = new CurrentAccount(accountNumber, customerName, balance);
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }

        int option;
        do {
            System.out.println("\nBanking Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Calculate Interest");
            System.out.println("4. Display Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.calculateInterest();
                    break;
                case 4:
                    account.printAccountDetails();
                    break;
                case 5:
                    System.out.println("Exiting Banking System...");
                    break;
                default:
                    System.out.println("Invalid option! Try again.");
            }
        } while (option != 5);

        scanner.close();
    }
}
