import java.util.HashMap; // prestoring and fetching from an array
import java.util.Map;
import java.util.Scanner;

class Bank {
    private Map<String, Double> accounts; // declare - private map to restrict access from unknown users

    public Bank() {
        accounts = new HashMap<>(); // initialize 
        accounts.put("1001", 5000.0);
        accounts.put("1002", 10000.5);
        accounts.put("1003", 7500.75);
        accounts.put("1004", 3200.0);
        accounts.put("1005", 8900.25);
    }

    // to check the balance of given acc
    public Double checkBalance(String accountNumber) {
        return accounts.get(accountNumber);  // Retrieve balance if the account exists, otherwise return null
    }
}

public class Task4 {
    public static void main(String[] args) {
        Bank bank = new Bank(); //creating obj of class bank
        Scanner sc = new Scanner(System.in);

        while (true) { // Infinite loop to keep asking for account number until valid input is given
            System.out.print("Enter your account number: "); // Prompt user to enter their account number
            String accountNumber = sc.nextLine(); // Read user input

            Double balance = bank.checkBalance(accountNumber); // Check if account number exists
            if (balance != null) { // If balance is found hten display it
                System.out.printf("Your account balance is: %f", balance);
                break; // Exit loop after showing balance
            } else { // If acc no is invalid
                System.out.println("Invalid account number. Please try again.");
            }
        }
    }
}
