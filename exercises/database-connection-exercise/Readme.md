# DatabaseConnect

This is a Java program that demonstrates how to connect to a MySQL database using JDBC.

# Dependencies

This program requires Java 8 or higher and the MySQL JDBC driver (mysql-connector-java.jar) to run

## Usage

To use this program, you need to have a MySQL database installed and running on your system. You also need to have the MySQL JDBC driver (mysql-connector-java.jar) in your classpath.

To connect to the database, you need to provide the following information:

- Hostname
- Port number
- Database name
- Username
- Password

You can provide this information in the `DatabaseConnect` class by modifying the following variables:

```java
String url = "jdbc:mysql://localhost:3306/mydatabase";
String username = "root";
String password = "password";
```

Once you have provided the correct information, you can run the main method in the DatabaseConnect class. This will connect to the database and execute a simple SQL query to retrieve some data from a table.
