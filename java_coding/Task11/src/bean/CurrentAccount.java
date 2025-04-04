package Task11.src.bean;

public class CurrentAccount extends Account {
    private float overdraftLimit;

    public CurrentAccount(Customer customer, float overdraftLimit) {
        super("Current", 0, customer);
        this.overdraftLimit = overdraftLimit;
    }

    public float getOverdraftLimit() {
        return overdraftLimit;
    }

    public float withdraw(float amount) {
        if (amount <= balance + overdraftLimit) {
            balance -= amount;
            return balance; // Return updated balance instead of boolean
        } else {
            System.out.println("Withdrawal exceeds overdraft limit!");
            return balance; // Return current balance if withdrawal fails
        }
    }
}
