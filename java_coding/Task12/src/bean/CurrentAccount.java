package Task12.src.bean;


public class CurrentAccount extends Account {
    private float overdraftLimit;

    public CurrentAccount(Customer customer, float overdraftLimit) {
        super("Current", 0, customer);
        this.overdraftLimit = overdraftLimit;
    }

    public float withdraw(float amount) {
        if (amount <= balance + overdraftLimit) {
            balance -= amount;
            return balance;
        } else {
            System.out.println("Overdraft limit exceeded!");
            return balance;
        }
    }
}