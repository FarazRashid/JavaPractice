import java.sql.*;
import java.util.Scanner;

public class DatabaseConnect {

    public static void main(String[] args) {
        
        try {
            // Prompt the user for input
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter database type (SQL or Oracle): ");

            String databaseType = scanner.nextLine();
            System.out.print("Enter username: ");

            String username = scanner.nextLine();
            System.out.print("Enter password: ");

            String password = scanner.nextLine();
            System.out.print("Enter query: ");

            String query = scanner.nextLine();

            // Create a connection to the database
            String driverClassName;
            String url;
            if (databaseType.equals("SQL")) 
            {
                driverClassName = "com.mysql.jdbc.Driver";
                url = "jdbc:mysql://localhost:3306/employees";

            } 
            else if (databaseType.equals("Oracle")) 
            {
                driverClassName = "oracle.jdbc.driver.OracleDriver";
                url = "jdbc:oracle:thin:@localhost:1521:xe";
            }
            else 
            {
                throw new IllegalArgumentException("Invalid database type: " + databaseType);
            }

            Class.forName(driverClassName);
            
            // Create a connection to the database
            Connection conn = DriverManager.getConnection(url, username, password);

            // Create a statement
            Statement stmt = conn.createStatement();

            // Execute the query
            ResultSet rs = stmt.executeQuery(query);

            // Process the results
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println(id + " " + name + " " + age);
            }

            // Close the connection
            conn.close();
        } 
        catch (Exception e) 
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
}