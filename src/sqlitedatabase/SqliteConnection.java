package src.sqlitedatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqliteConnection {

    private static java.sql.Connection con = null;
    public static Connection getConnection()
    {
        if (con == null ){
            String url = "jdbc:sqlite:src/sqlitedatabase/TaxiBarcelona.sqlite";
            String user = "root";
            String pass = "root";
            try {
                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection(url);
            }
            catch (ClassNotFoundException | SQLException e) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }
            System.out.println("Opened database successfully");
        }
        return con;
    }
}
