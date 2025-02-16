import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import java.sql.*;
          public class connection  {
          public static void main(String[] args) {
          String jdbcURL = "jdbc:mysql://localhost:3306/?user=root";
          String username="root";
 String pass="vivek"; 
try (Connection connection = DriverManager.getConnection(jdbcURL, username, pass))
{
           System.out.println("Connected to the database successfully!");
} 
catch (SQLException e) {
          System.err.println("Error: Unable to connect to the database.");
 e.printStackTrace(); }
}
}
