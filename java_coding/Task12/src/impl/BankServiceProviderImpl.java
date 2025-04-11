package Task12.src.impl;

import Task11.src.service.IBankServiceProvider;
import Task11.src.bean.*;

public class BankServiceProviderImpl extends CustomerServiceProviderImpl implements IBankServiceProvider {
    private String branchName;
    private String branchAddress;

    @Override
    public void createAccount(Customer customer, String accType, float balance) {
        Account account;
        switch (accType.toLowerCase()) {
            case "savings":
                account = new SavingsAccount(customer, 3.5f);
                break;
            case "current":
                account = new CurrentAccount(customer, 10000);
                break;
            case "zerobalance":
                account = new ZeroBalanceAccount(customer);
                break;
            default:
                System.out.println("Invalid account type.");
                return;
        }
        accounts.add(account);
        System.out.println("Account created successfully. Account No: " + account.getAccountNumber());
    }

    @Override
    public Account[] listAccounts() {
        return accounts.toArray(new Account[0]);
    }

    @Override
    public void calculateInterest() {
        for (Account acc : accounts) {
            if (acc instanceof SavingsAccount) {
                acc.setBalance(acc.getBalance() * 1.05f);
            }
        }
    }
}