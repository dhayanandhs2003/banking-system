package Task14.bean;

public class SavingsAccount extends Account {
    public SavingsAccount(long accountNumber, float balance) {
        super(accountNumber, balance);
    }

    @Override
    public String getAccountType() {
        return "Savings";
    }
}