# DatabaseConnect

This is a Java program that demonstrates how to connect to a MySQL database using JDBC.

# Dependencies

This program requires Java 8 or higher and access to a MySQL or Oracle database.

## Overview

**DatabaseConnect** is a Java application that enables you to connect to different types of databases (MySQL and Oracle) and execute SQL queries or updates. It provides a simple command-line interface for interacting with databases.

## Usage

To use this program, you need to have a MySQL database or Oracle database installed and running on your system. If you are using a MySQL database, you need to download the MySQL JDBC driver (mysql-connector-java.jar) and add it to your classpath.

If you are using an Oracle database, you need to download the Oracle JDBC driver (ojdbc8.jar) and add it to your classpath.

To connect to the database, you need to provide the following information:

- Hostname
- Port number
- Database name
- Username
- Password

You can provide this information in the `DatabaseConnect` class by following the prompts

## Example Usage

```Enter database type (SQL or Oracle): SQL
Enter URL: jdbc:mysql://localhost:3306/mydatabase
Enter username: myusername
Enter password: mypassword
Enter query: SELECT * FROM users;

```
