import java.sql.*;
import java.util.Scanner;

public class DatabaseConnect {

    private Connection conn;
    private Statement stmt;

    public DatabaseConnect(String databaseType, String url, String username, String password) throws SQLException, ClassNotFoundException {
        String driverClassName;
        if (databaseType.equals("SQL")) 
        {
            driverClassName = "com.mysql.jdbc.Driver";
        } 
        else if (databaseType.equals("Oracle")) 
        {
            driverClassName = "oracle.jdbc.driver.OracleDriver";
        } 
        else 
        {
            throw new IllegalArgumentException("Invalid database type: " + databaseType);
        }

        Class.forName(driverClassName);

        // Create a connection to the database
        conn = DriverManager.getConnection(url, username, password);

        // Create a statement
        stmt = conn.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return stmt.executeQuery(query);
    }

    public int executeUpdate(String query) throws SQLException {
        return stmt.executeUpdate(query);
    }

    public void close() throws SQLException {
        conn.close();
    }

    public static void main(String[] args) {
        try {
            // Prompt the user for input
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter database type (SQL or Oracle): ");
            String databaseType = scanner.nextLine();
            System.out.print("Enter URL: ");
            String url = scanner.nextLine();
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            System.out.print("Enter query: ");
            String query = scanner.nextLine();

            // Create a new DatabaseConnect object
            DatabaseConnect db = new DatabaseConnect(databaseType, url, username, password);

            // Execute the query or update based on the query type
            if (isSelectQuery(query)) 
            {
                ResultSet rs = db.executeQuery(query);
                // Process the results
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    System.out.println(id + " " + name + " " + age);
                }
            } else {
                int rowsAffected = db.executeUpdate(query);
                System.out.println(rowsAffected + " rows affected.");
            }

            // Close the connection
            db.close();
        } 
        catch (Exception e) 
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    private static boolean isSelectQuery(String query) {
        return query.trim().toLowerCase().startsWith("select");
    }
}