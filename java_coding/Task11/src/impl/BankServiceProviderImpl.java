package Task11.src.impl;

import Task11.src.service.IBankServiceProvider;

import java.util.ArrayList;
import java.util.List;

import Task11.src.bean.*;

public class BankServiceProviderImpl extends CustomerServiceProviderImpl implements IBankServiceProvider {
    private String branchName;
    private String branchAddress;
    private List<Account> accountList = new ArrayList<>(); // Fix

    @Override
    public void createAccount(Customer customer, String accType, float balance) {
        Account account;
        switch (accType.toLowerCase()) {
            case "savings":
                account = new SavingsAccount(customer, 3.5f); // Example interest rate
                break;
            case "current":
                account = new CurrentAccount(customer, 10000); // Example overdraft limit
                break;
            case "zerobalance":
                account = new ZeroBalanceAccount(customer);
                break;
            default:
                System.out.println("Invalid account type.");
                return;
        }
        accountList.add(account); // Store the account
        System.out.println("Account created successfully. Account No: " + account.getAccountNumber());
    }

    @Override
    public Account[] listAccounts() {
        return accountList.toArray(new Account[0]); // Use accountList instead of accounts
    }

    @Override
    public void calculateInterest() {
        for (Account acc : accountList) { // Use accountList instead of accounts
            if (acc instanceof SavingsAccount) {
                acc.setBalance(acc.getBalance() * 1.05f);
            }
        }
    }
}


