package Task11.src.app;

import java.util.Scanner;
import Task11.src.impl.BankServiceProviderImpl;
import Task11.src.bean.Customer;

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankServiceProviderImpl bankService = new BankServiceProviderImpl();

        while (true) {
            System.out.println("1. Create Account\n2. Deposit\n3. Withdraw\n4. Get Balance\n5. Transfer\n6. Get Account Details\n7. List Accounts\n8. Exit");
            int choice = scanner.nextInt();
            if (choice == 8) break;

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter Name, Address, Phone:");
                    scanner.nextLine();
                    String name = scanner.nextLine(), address = scanner.nextLine(), phone = scanner.nextLine();
                    bankService.createAccount(new Customer(name, address, phone), "Savings", 500);
                }
                default -> System.out.println("Invalid Choice!");
            }
        }
        scanner.close();
    }
}


