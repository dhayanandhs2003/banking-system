// Task 6 

import java.util.HashMap;
import java.util.Scanner;

public class Task6 {
    // private HashMap<Integer, String> transactions; // private declaration of hash - Stores transaction ID and details
    // private int transactionId; // Unique ID for transactions

    // // Constructor to ensure the transactions starts empty to initialize HashMap and transaction ID counter
    // public Task6() {
    //     transactions = new HashMap<>();
    //     transactionId = 1;
    // }

    // instead of the above line i can straight up declare and initialize the hashmap like this but the constructor method will help in structured format.

    private HashMap<Integer, String> transactions = new HashMap<>();
    private int transactionId = 1;

    // Method to add a transaction
    public void addTransaction(String type, double amount) {
        transactions.put(transactionId, type + ": $" + String.format("%.2f", amount));
        // the above line formats the inputs from call function
        transactionId++; // Increment transaction ID
    }

    // Method to display all transactions
    public void displayTransactions() {
        System.out.println("\nTransaction History:");
        if (transactions.isEmpty()) {
            System.out.println("No transactions available.");
        } else {
            for (int id : transactions.keySet()) {
                System.out.println(id + ". " + transactions.get(id));
            }
        }
    }

    // Main method to handle user input
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Task6 bank = new Task6(); // instance/obj for the class 

        while (true) {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter deposit amount: ");
                double amount = sc.nextDouble();
                bank.addTransaction("Deposit", amount);
                System.out.println("Deposit successful.");

            } else if (choice == 2) {
                System.out.print("Enter withdrawal amount: ");
                double amount = sc.nextDouble();
                bank.addTransaction("Withdrawal", amount);
                System.out.println("Withdrawal successful.");

            } else if (choice == 3) {
                bank.displayTransactions();
                System.out.println("Exiting program.");
                break;

            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }
}

