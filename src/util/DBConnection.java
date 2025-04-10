package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.IOException;

public class DBConnection {

    private static Connection connection = null;

    public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        if (connection == null) {
            Properties props = PropertyUtil.getConnectionProperties("src/database.properties");

            String url = props.getProperty("db.url");
            String user = props.getProperty("db.username");
            String pass = props.getProperty("db.password");
            String driver = props.getProperty("db.driver");

            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, pass);
        }
        return connection;
    }
}

