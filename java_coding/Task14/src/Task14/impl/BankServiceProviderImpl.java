package Task14.impl;

import Task14.bean.*;
import Task14.service.IBankServiceProvider;

import java.beans.Customizer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BankServiceProviderImpl implements IBankServiceProvider {
    private List<Account> accounts = new ArrayList<>();

    public void connectDatabase() throws SQLException {
        throw new SQLException("Database connection failed!");
    }

    private static long nextAccountNumber = 1000001; // starting point

@Override
public void createAccount(Customer customer, String accType, float balance) {
    Account acc = null;
    long accountNumber = nextAccountNumber++;

    switch (accType.toLowerCase()) {
        case "savings":
            acc = new SavingsAccount(accountNumber, balance);
            break;
        case "current":
            acc = new CurrentAccount(accountNumber, balance);
            break;
        case "zero":
            acc = new ZeroBalanceAccount(accountNumber); // assuming zero balance accounts don’t require initial balance
            break;
        default:
            System.out.println("Invalid account type.");
            return;
    }

    accounts.add(acc);
    System.out.println(acc.getAccountType() + " Account Created: " + acc.getAccountNumber());
}



    @Override
    public Account[] listAccounts() {
        return accounts.toArray(new Account[0]);
    }

    public static void main(String[] args) {
        BankServiceProviderImpl service = new BankServiceProviderImpl();

        try {
            service.connectDatabase();
        } catch (SQLException e) {
            System.out.println("Handled SQLException: " + e.getMessage());
        }

        service.createAccount(new SavingsAccount(1001, 5000));
        service.createAccount(new CurrentAccount(1002, 7000));
        service.createAccount(new ZeroBalanceAccount(1003, 0));

        for (Account acc : service.listAccounts()) {
            System.out.println("Account Type: " + acc.getAccountType() +
                ", Account Number: " + acc.getAccountNumber() +
                ", Balance: " + acc.getBalance());
        }
    }

    private void createAccount(ZeroBalanceAccount zeroBalanceAccount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createAccount'");
    }



    private void createAccount(SavingsAccount savingsAccount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createAccount'");
    }



    private void createAccount(CurrentAccount savingsAccount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createAccount'");
    }



    public void transfer(long fromAcc, long toAcc, float transferAmount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'transfer'");
    }

    public void withdraw(long accNoWithdraw, float amountWithdraw) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'withdraw'");
    }

    public float getAccountBalance(long accNoBalance) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAccountBalance'");
    }

    public void deposit(long accNoDeposit, float amountDeposit) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deposit'");
    }

    public void createAccount(Customizer customer, String type, float deposit) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createAccount'");
    }

    public char[] getAccountDetails(long accDetail) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAccountDetails'");
    }

   
}