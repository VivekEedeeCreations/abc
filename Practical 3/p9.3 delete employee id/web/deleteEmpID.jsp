<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Employee Deletion Status</title>
</head>
<body>
    <h1>Samruddhi</h1>
    <h2>Employee Deletion Status</h2>

    <%
        String employeeIdStr = request.getParameter("employee_id");
        String dbUrl = "jdbc:mysql://localhost:3306/sys?useSSL=false";
        String dbUser = "root";  // Change to your MySQL username
        String dbPassword = "vivek";  // Change to your MySQL password
        Connection conn = null;
        Statement stmt = null;
        int employeeId = 0; // Default employeeId

        try {
            // Ensure the MySQL JDBC Driver is loaded
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");  // Ensure MySQL driver is loaded
            } catch (ClassNotFoundException e) {
                out.println("<p>Error: MySQL JDBC Driver not found!</p>");
                return;
            }

            // Validate the employeeId parameter and convert it to integer
            if (employeeIdStr != null && !employeeIdStr.trim().isEmpty()) {
                employeeId = Integer.parseInt(employeeIdStr); // Parse employee_id to integer
            } else {
                out.println("<p>Invalid employee ID input. Please enter a valid employee ID.</p>");
                return;
            }

            // Step 1: Establish a connection to the database
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);  // Get connection

            // Step 2: Create a statement object
            stmt = conn.createStatement();

            // Step 3: Write the SQL DELETE query
            String sql = "DELETE FROM employee WHERE id = " + employeeId;

            // Step 4: Execute the DELETE query
            int result = stmt.executeUpdate(sql);

            // Step 5: Check if the deletion was successful
            if (result > 0) {
                out.println("<p>Employee with ID " + employeeId + " has been successfully deleted.</p>");
            } else {
                out.println("<p>No employee found with ID " + employeeId + ". Deletion failed.</p>");
            }

        } catch (Exception e) {
            // Handle any exceptions and display the error message
            out.println("<p>Error: " + e.getMessage() + "</p>");
            e.printStackTrace();
        } finally {
            // Step 6: Close the database resources
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    %>

</body>
</html>
