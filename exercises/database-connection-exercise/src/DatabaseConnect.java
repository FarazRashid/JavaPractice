import java.sql.*;


public class DatabaseConnect {
    
    public static void main(String[] args) {
        
        try {
            // Create a connection to the database
            String driverClassName="com.mysql.jdbc.Driver";
            String url="jdbc:mysql://localhost:3306/employees";
            String username="root";
            String password="root";
            String query="SELECT * FROM employees";


            Class.forName(driverClassName);

            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("first_name") + " " + resultSet.getString("last_name"));
            }
            connection.close();
           
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
       

    }
}
