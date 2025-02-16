<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Employee Records</title>
</head>
<body>
    
    <h2>Employee Records</h2>

    <%

        // Database connection variables
        String dbUrl = "jdbc:mysql://localhost:3306/employees";  // Database URL
        String dbUser = "root";  // Change to your MySQL username
        String dbPassword = "root75";  // Change to your MySQL password

        // Initialize connection and statement
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Ensure the MySQL JDBC Driver is loaded
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");  // Ensure MySQL driver is loaded
            } catch (ClassNotFoundException e) {
                out.println("<p>Error: MySQL JDBC Driver not found!</p>");
                return;
            }

            // Step 1: Establish a connection to the database
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);  // Get connection

            // Step 2: Create a Statement object
            stmt = conn.createStatement();

            // Step 3: Write the SQL SELECT query to fetch all records
            String sql = "SELECT * FROM employee";  // SQL to select all employees

            // Step 4: Execute the query and get the result set
            rs = stmt.executeQuery(sql);

            // Step 5: Display the result set in an HTML table
            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>First Name</th><th>Last Name</th><th>Department</th><th>Position</th><th>Salary</th></tr>");

            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String department = rs.getString("department");
                String position = rs.getString("position");
                double salary = rs.getDouble("salary");

                out.println("<tr>");
                out.println("<td>" + id + "</td>");
                out.println("<td>" + firstName + "</td>");
                out.println("<td>" + lastName + "</td>");
                out.println("<td>" + department + "</td>");
                out.println("<td>" + position + "</td>");
                out.println("<td>" + salary + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");

        } catch (Exception e) {
            // Handle any exceptions and display error message
            out.println("<p>Error: " + e.getMessage() + "</p>");
            e.printStackTrace();
        } finally {
            // Step 6: Close the database resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    %>

</body>
</htm
