package Task14.bean;

public class CurrentAccount extends Account {
    public CurrentAccount(long accountNumber, float balance) {
        super(accountNumber, balance);
    }

    @Override
    public String getAccountType() {
        return "Current";
    }
}