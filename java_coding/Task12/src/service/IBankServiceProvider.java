package Task12.src.service;

import Task11.src.bean.*;

public interface IBankServiceProvider extends ICustomerServiceProvider {
    void createAccount(Customer customer, String accType, float balance);
    Account[] listAccounts();
    void calculateInterest();
}