package Task12.src.bean;


public class SavingsAccount extends Account {
    private float interestRate;

    public SavingsAccount(Customer customer, float interestRate) {
        super("Savings", 500, customer);
        this.interestRate = interestRate;
    }
}