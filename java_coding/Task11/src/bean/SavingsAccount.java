package Task11.src.bean;

public class SavingsAccount extends Account {
    private float interestRate;
    private static final float MIN_BALANCE = 500;

    public SavingsAccount(Customer customer, float interestRate) {
        super("Savings", MIN_BALANCE, customer);
        this.interestRate = interestRate;
    }
}
