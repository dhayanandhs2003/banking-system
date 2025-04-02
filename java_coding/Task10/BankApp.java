package Task10;

import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEnter command: create_account, deposit, withdraw, get_balance, transfer, getAccountDetails, exit");
            String command = scanner.next();

            switch (command) {
                case "create_account":
                    System.out.println("Enter customer details: ID, First Name, Last Name, Email, Phone, Address");
                    String id = scanner.next();
                    String firstName = scanner.next();
                    String lastName = scanner.next();
                    String email = scanner.next();
                    String phone = scanner.next();
                    scanner.nextLine(); // Consume leftover newline
                    String address = scanner.nextLine();

                    Customer customer = new Customer(id, firstName, lastName, email, phone, address);

                    System.out.println("Enter account type (Savings/Current):");
                    String accType = scanner.next();

                    float balance;
                    while (true) {
                        System.out.print("Enter initial balance: ");
                        if (scanner.hasNextFloat()) {
                            balance = scanner.nextFloat();
                            scanner.nextLine(); // Consume newline left-over
                            break;
                        } else {
                            System.out.println("Invalid input. Please enter a valid number.");
                            scanner.next(); // Clear invalid input
                        }
                    }

                    bank.createAccount(customer, accType, balance);
                    break;

                case "deposit":
                    System.out.println("Enter account number and amount:");
                    bank.deposit(scanner.nextLong(), scanner.nextFloat());
                    break;

                case "withdraw":
                    System.out.println("Enter account number and amount:");
                    bank.withdraw(scanner.nextLong(), scanner.nextFloat());
                    break;

                case "get_balance":
                    System.out.println("Enter account number:");
                    System.out.println("Balance: $" + bank.getAccountBalance(scanner.nextLong()));
                    break;

                case "transfer":
                    System.out.println("Enter from account, to account, and amount:");
                    bank.transfer(scanner.nextLong(), scanner.nextLong(), scanner.nextFloat());
                    break;

                case "getAccountDetails":
                    System.out.println("Enter account number:");
                    bank.getAccountDetails(scanner.nextLong());
                    break;

                case "exit":
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid command.");
            }
        }
    }
}
