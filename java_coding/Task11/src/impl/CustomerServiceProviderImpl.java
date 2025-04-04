package Task11.src.impl;

import Task11.src.service.ICustomerServiceProvider;
import Task11.src.bean.Account;
import java.util.ArrayList;
import java.util.List;

import Task11.src.bean.SavingsAccount;
import Task11.src.bean.CurrentAccount;
import Task11.src.bean.ZeroBalanceAccount;


public class CustomerServiceProviderImpl implements ICustomerServiceProvider {
    protected List<Account> accounts = new ArrayList<>();

    @Override
    public float getAccountBalance(long accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accountNumber) {
                return acc.getBalance();
            }
        }
        return -1;
    }

    @Override
public float deposit(long accountNumber, float amount) {
    for (Account acc : ((BankServiceProviderImpl) this).listAccounts()) {
        if (acc.getAccountNumber() == accountNumber) {
            acc.setBalance(acc.getBalance() + amount);
            return acc.getBalance();
        }
    }
    System.out.println("Account not found!");
    return -1;
}

@Override
public float withdraw(long accountNumber, float amount) {
    for (Account acc : ((BankServiceProviderImpl) this).listAccounts()) {
        if (acc.getAccountNumber() == accountNumber) {
            if (acc instanceof SavingsAccount && acc.getBalance() - amount < 500) {
                System.out.println("Cannot withdraw, minimum balance should be 500!");
                return acc.getBalance();
            }
            if (acc instanceof CurrentAccount) {
                return ((CurrentAccount) acc).withdraw(amount);
            }
            if (acc.getBalance() >= amount) {
                acc.setBalance(acc.getBalance() - amount);
                return acc.getBalance();
            } else {
                System.out.println("Insufficient funds!");
                return acc.getBalance();
            }
        }
    }
    System.out.println("Account not found!");
    return -1;
}

@Override
public void transfer(long fromAccountNumber, long toAccountNumber, float amount) {
    float withdrawn = withdraw(fromAccountNumber, amount);
    if (withdrawn != -1) {
        deposit(toAccountNumber, amount);
    }
}


    @Override
    public String getAccountDetails(long accountNumber) {
    for (Account acc : ((BankServiceProviderImpl) this).listAccounts()) {
        if (acc.getAccountNumber() == accountNumber) {
            return acc.toString();
        }
    }
    return "Account not found!";
    }
}
