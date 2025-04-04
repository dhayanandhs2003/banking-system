package Task11.src.service;

import Task11.src.bean.Account;
import Task11.src.bean.Customer;

public interface IBankServiceProvider {
    void createAccount(Customer customer, String accType, float balance);
    Account[] listAccounts();
    void calculateInterest();
}

