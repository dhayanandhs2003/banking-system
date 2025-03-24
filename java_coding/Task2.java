import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your current balance: ");
        double balance = scanner.nextDouble();
        
        System.out.println("ATM Options:");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        
        System.out.print("Choose an option (1-3): ");
        int choice = scanner.nextInt();
        
        if (choice == 1) {
            System.out.println("Your current balance is: Rs. " + balance);
        } else if (choice == 2) {
            System.out.print("Enter amount to withdraw: ");
            double withdrawAmount = scanner.nextDouble();
            
            if (withdrawAmount > balance) {
                System.out.println("Insufficient balance!");
            } else if (withdrawAmount % 100 != 0 && withdrawAmount % 500 != 0) {
                System.out.println("Withdrawal amount must be in multiples of 100 or 500.");
            } else {
                balance -= withdrawAmount;
                System.out.println("Withdrawal successful! Remaining balance: Rs. " + balance);
            }
        } else if (choice == 3) {
            System.out.print("Enter amount to deposit: ");
            double depositAmount = scanner.nextDouble();
            
            if (depositAmount <= 0) {
                System.out.println("Invalid deposit amount!");
            } else {
                balance += depositAmount;
                System.out.println("Deposit successful! Updated balance: Rs. " + balance);
            }
        } else {
            System.out.println("Invalid choice. Please select a valid option.");
        }
        
        scanner.close();
    }
}

