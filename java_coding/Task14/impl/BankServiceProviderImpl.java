
package Task14.impl;

import java.sql.SQLException;

public class BankServiceProviderImpl {
    public void connectDatabase() throws SQLException {
        throw new SQLException("Database connection failed!");
    }

    public static void main(String[] args) {
        BankServiceProviderImpl service = new BankServiceProviderImpl();
        try {
            service.connectDatabase();
        } catch (SQLException e) {
            System.out.println("Handled SQLException: " + e.getMessage());
        }
    }
}
