package Task14.service;

import Task14.bean.Account;
import Task14.bean.Customer;

public interface IBankServiceProvider {
    void createAccount(Customer customer, String accType, float balance);
    Account[] listAccounts();
}

