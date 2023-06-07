package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/case_md3?useSSL=false";

    private static final String jdbcUsername = "root";

    private static final String jdbcPassword = "12345678";

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
