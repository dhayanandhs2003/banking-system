package Task11.src.bean;

public class ZeroBalanceAccount extends Account {
    public ZeroBalanceAccount(Customer customer) {
        super("Zero Balance", 0, customer);
    }
}
