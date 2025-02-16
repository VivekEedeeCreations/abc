import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class deleteId extends HttpServlet {
// JDBC credentials (update with your own)
private static final String URL = "jdbc:mysql://localhost:3306/sys?useSSL=false";
private static final String USER = "root";
private static final String PASSWORD = "vivek";
// JDBC connection
private Connection connection;
@Override
public void init() throws ServletException {
try {
// Initialize the database connection
Class.forName("com.mysql.cj.jdbc.Driver");
connection = DriverManager.getConnection(URL, USER, PASSWORD);
} catch (Exception e) {
throw new ServletException("Database connection error", e);
}
}
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
// Send the HTML form to the client
response.setContentType("text/html");
PrintWriter out = response.getWriter();
out.println("<html>");
out.println("<head><title>Delete Student</title></head>");
out.println("<body>");
out.println("<h2>Delete Student by ID</h2>");
out.println("<form action='deleteId' method='post'>"); // Corrected form action
out.println("<label for='id'>Student ID:</label>");
out.println("<input type='text' id='id' name='id' required><br><br>");
out.println("<input type='submit' value='Delete Student'>");
out.println("</form>");
out.println("</body>");
out.println("</html>");
}
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
// Get the student ID from the form
String studentId = request.getParameter("id");
// SQL query to delete student based on ID
String sql = "DELETE FROM student WHERE id = ?"; // Using PreparedStatement for

try (PreparedStatement stmt = connection.prepareStatement(sql)) {
// Set the student ID parameter
stmt.setInt(1, Integer.parseInt(studentId));
// Execute the delete query
int rowsAffected = stmt.executeUpdate();
// Prepare response based on success or failure
response.setContentType("text/html");
PrintWriter out = response.getWriter();
out.println("<html>");
out.println("<head><title>Delete Result</title></head>");
out.println("<body>");
if (rowsAffected > 0) {
out.println("<h3>Student with ID " + studentId + " was successfully deleted!</h3>");
} else {
out.println("<h3>No student found with ID " + studentId + "</h3>");
}
out.println("<a href=''>Go back to the form</a>");
out.println("</body>");
out.println("</html>");
} catch (SQLException e) {
e.printStackTrace();
throw new ServletException("Error deleting student", e);
}
}
@Override
public void destroy() {
try {
if (connection != null) {
connection.close();
}
} catch (SQLException e) {
e.printStackTrace();
}
}
}
