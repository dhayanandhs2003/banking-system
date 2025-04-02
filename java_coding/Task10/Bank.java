package Task10;

import java.util.HashMap;

public class Bank {
    private HashMap<Long, Account> accounts = new HashMap<>();

    public void createAccount(Customer customer, String accType, float balance) {
        Account newAccount = new Account(customer, accType, balance);
        accounts.put(newAccount.getAccountNumber(), newAccount);
        System.out.println("Account successfully created! Account Number: " + newAccount.getAccountNumber());
    }

    public float getAccountBalance(long accNo) {
        Account account = accounts.get(accNo);
        return (account != null) ? account.getBalance() : -1;
    }

    public void deposit(long accNo, float amount) {
        Account account = accounts.get(accNo);
        if (account != null) {
            account.deposit(amount);
            System.out.println("Deposit successful! New Balance: $" + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw(long accNo, float amount) {
        Account account = accounts.get(accNo);
        if (account != null && account.withdraw(amount)) {
            System.out.println("Withdrawal successful! New Balance: $" + account.getBalance());
        } else {
            System.out.println("Withdrawal failed.");
        }
    }

    public void transfer(long fromAccNo, long toAccNo, float amount) {
        Account fromAccount = accounts.get(fromAccNo);
        Account toAccount = accounts.get(toAccNo);
        
        if (fromAccount != null && toAccount != null && fromAccount.withdraw(amount)) {
            toAccount.deposit(amount);
            System.out.println("Transfer successful! New Balance: $" + fromAccount.getBalance());
        } else {
            System.out.println("Transfer failed. Check account details or balance.");
        }
    }

    public void getAccountDetails(long accNo) {
        Account account = accounts.get(accNo);
        if (account != null) {
            account.printAccountDetails();
        } else {
            System.out.println("Account not found.");
        }
    }
}
