import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class registration extends HttpServlet {
// JDBC URL, username, and password
private static final String DB_URL =
"jdbc:mysql://localhost:3306/?user=root&useSSL=false";
private static final String DB_USERNAME = "root"; // Your MySQL username
private static final String DB_PASSWORD = "vivek"; // Your MySQL password
// Handles GET requests
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter out = response.getWriter();
out.println("<html><body>");
out.println("<h3>Name: 5358 Samruddhi Surve</h3>");
out.println("<form action='registration' method='POST'>");
out.println("ID: <input type='text' name='id' required><br><br>");
out.println("Name: <input type='text' name='name' required><br><br>");
out.println("Age: <input type='text' name='age' required><br><br>");
out.println("Grade: <input type='text' name='grade' required><br><br>");
out.println("<button type='submit'>Submit</button>");
out.println("</form>");
out.println("</body></html>");
}
// Handles POST requests
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter out = response.getWriter();
// Retrieve form data
String id = request.getParameter("id");
String name = request.getParameter("name");
String age = request.getParameter("age");
String grade = request.getParameter("grade");
try {
// Load JDBC driver
Class.forName("com.mysql.cj.jdbc.Driver");
// Connect to the database
try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME,
DB_PASSWORD)) {
// Update SQL query to use the 'student' table
String sql = "INSERT INTO sys.student (id, name, age, grade) VALUES (?, ?, ?, ?)";
try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
// Handle ID conversion and potential errors
try {
pstmt.setInt(1, Integer.parseInt(id)); // Ensuring that id is an integer
} catch (NumberFormatException e) {
out.println("<p style='color:red;'>Error: ID must be an integer.</p>");
return; // Stop further processing if ID is invalid
}
pstmt.setString(2, name);
pstmt.setString(3, age);
pstmt.setString(4, grade);
// Execute the query
int rowsAffected = pstmt.executeUpdate();
if (rowsAffected > 0) {
out.println("<p style='color:green;'>User registered successfully with ID: " + id +
"!</p>");
} else {
out.println("<p style='color:red;'>Error in registering user.</p>");
}
}
} catch (SQLException e) {
e.printStackTrace();
out.println("<p style='color:red;'>Database error: " + e.getMessage() + "</p>");
}
} catch (ClassNotFoundException e) {
e.printStackTrace();
out.println("<p style='color:red;'>JDBC Driver not found: " + e.getMessage() + "</p>");
}
}
}
