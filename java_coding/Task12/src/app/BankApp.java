package Task12.src.app;

import Task11.src.impl.BankServiceProviderImpl;
import Task11.src.bean.Customer;
import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        BankServiceProviderImpl bank = new BankServiceProviderImpl();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Get Balance");
            System.out.println("5. Transfer");
            System.out.println("6. Get Account Details");
            System.out.println("7. List Accounts");
            System.out.println("8. Exit");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    String type;
                    do {
                        System.out.println("Enter account type (Savings, Current, ZeroBalance) or 'exit' to finish:");
                        type = sc.nextLine();
                        if (!type.equalsIgnoreCase("exit")) {
                            System.out.println("Enter Name, Address, Phone:");
                            Customer c = new Customer(sc.nextLine(), sc.nextLine(), sc.nextLine());
                            bank.createAccount(c, type, 0);
                        }
                    } while (!type.equalsIgnoreCase("exit"));
                    break;
                case 2:
                    System.out.println("Enter account number and amount:");
                    bank.deposit(sc.nextLong(), sc.nextFloat());
                    sc.nextLine();
                    break;
                case 3:
                    System.out.println("Enter account number and amount:");
                    bank.withdraw(sc.nextLong(), sc.nextFloat());
                    sc.nextLine();
                    break;
                case 4:
                    System.out.println("Enter account number:");
                    System.out.println(bank.getAccountBalance(sc.nextLong()));
                    sc.nextLine();
                    break;
                case 5:
                    System.out.println("Enter from acc, to acc, and amount:");
                    bank.transfer(sc.nextLong(), sc.nextLong(), sc.nextFloat());
                    sc.nextLine();
                    break;
                case 6:
                    System.out.println("Enter account number:");
                    System.out.println(bank.getAccountDetails(sc.nextLong()));
                    sc.nextLine();
                    break;
                case 7:
                    for (var acc : bank.listAccounts()) {
                        System.out.println(acc);
                    }
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 8);
        sc.close();
    }
}