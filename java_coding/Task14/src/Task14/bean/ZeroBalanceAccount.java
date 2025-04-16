package Task14.bean;

public class ZeroBalanceAccount extends Account {
    
    // Existing constructor
    public ZeroBalanceAccount(long accountNumber) {
        super(accountNumber, 0.0f);
    }

    // ✅ Add this constructor to match the call with (accountNumber, balance)
    public ZeroBalanceAccount(long accountNumber, float balance) {
        super(accountNumber, balance);
    }

    @Override
    public String getAccountType() {
        return "Zero Balance";
    }
}