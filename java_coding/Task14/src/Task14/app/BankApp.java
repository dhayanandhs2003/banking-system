package Task14.app;

import Task14.impl.BankServiceProviderImpl;
import Task14.bean.Customer;
import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        BankServiceProviderImpl bankService = new BankServiceProviderImpl();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to the Banking System");
        System.out.println("--------------------------------");

        while (!exit) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Get Balance");
            System.out.println("5. Transfer");
            System.out.println("6. Get Account Details");
            System.out.println("7. List Accounts");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter customer name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter email: ");
                        String email = scanner.nextLine();
                        System.out.print("Enter phone number: ");
                        String phone = scanner.nextLine();
                        Customer customer = new Customer(name, email, phone);


                        System.out.println("Choose Account Type: savings, current, zerobalance");
                        String type = scanner.nextLine().toLowerCase();

                        System.out.print("Enter initial deposit: ");
                        float deposit = scanner.nextFloat();
                        scanner.nextLine();

                        bankService.createAccount(customer, type, deposit);
                        break;

                    case 2:
                        System.out.print("Enter account number: ");
                        long accNoDeposit = scanner.nextLong();
                        System.out.print("Enter amount to deposit: ");
                        float amountDeposit = scanner.nextFloat();
                        bankService.deposit(accNoDeposit, amountDeposit);
                        break;

                    case 3:
                        System.out.print("Enter account number: ");
                        long accNoWithdraw = scanner.nextLong();
                        System.out.print("Enter amount to withdraw: ");
                        float amountWithdraw = scanner.nextFloat();
                        bankService.withdraw(accNoWithdraw, amountWithdraw);
                        break;

                    case 4:
                        System.out.print("Enter account number: ");
                        long accNoBalance = scanner.nextLong();
                        float balance = bankService.getAccountBalance(accNoBalance);
                        System.out.println("Balance: ₹" + balance);
                        break;

                    case 5:
                        System.out.print("Enter sender account number: ");
                        long fromAcc = scanner.nextLong();
                        System.out.print("Enter receiver account number: ");
                        long toAcc = scanner.nextLong();
                        System.out.print("Enter amount to transfer: ");
                        float transferAmount = scanner.nextFloat();
                        bankService.transfer(fromAcc, toAcc, transferAmount);
                        break;

                    case 6:
                        System.out.print("Enter account number: ");
                        long accDetail = scanner.nextLong();
                        System.out.println(bankService.getAccountDetails(accDetail));
                        break;

                    case 7:
                        System.out.println("List of Accounts:");
                        for (var acc : bankService.listAccounts()) {
                            System.out.println(acc);
                        }
                        break;

                    case 8:
                        exit = true;
                        System.out.println("Thank you for using the Banking System!");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
