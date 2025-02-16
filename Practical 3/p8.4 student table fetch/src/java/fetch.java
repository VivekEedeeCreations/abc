import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/FetchStudentRecords")
public class fetch extends HttpServlet {
private static final long serialVersionUID = 1L;
// Database credentials
private static final String DB_URL = "jdbc:mysql://localhost:3306/sys?useSSL=false";
private static final String DB_USER = "root";
private static final String DB_PASSWORD = "vivek";
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
response.setContentType("text/html");
PrintWriter out = response.getWriter();
try {
// Load JDBC driver (optional for newer versions)
Class.forName("com.mysql.cj.jdbc.Driver");
// Establish database connection
Connection connection = DriverManager.getConnection(DB_URL, DB_USER,
DB_PASSWORD);
// Create Statement
Statement statement = connection.createStatement();
// Execute Query
String query = "SELECT * FROM student";
ResultSet resultSet = statement.executeQuery(query);
// Generate HTML table to display results
out.println("<html><body>");
out.println("<h2>Samruddhi Surve 5358</h2>");
out.println("<h2>Student Records</h2>");
out.println("<table border='1'>");
out.println("<tr><th>ID</th><th>Name</th><th>Age</th><th>Grade</th></tr>");
while (resultSet.next()) {
int id = resultSet.getInt("id");
String name = resultSet.getString("name");
int age = resultSet.getInt("age");
String grade = resultSet.getString("grade");
out.println("<tr>");
out.println("<td>" + id + "</td>");
out.println("<td>" + name + "</td>");
out.println("<td>" + age + "</td>");
out.println("<td>" + grade + "</td>");
out.println("</tr>");
}
out.println("</table>");
out.println("</body></html>");
// Close connections
resultSet.close();
statement.close();
connection.close();
} catch (ClassNotFoundException e) {
out.println("<p style='color:red;'>Error: Unable to load database driver!</p>");
} catch (SQLException e) {
out.println("<p style='color:red;'>Error: Database operation failed! " + e.getMessage() +
"</p>");
}
}
}
