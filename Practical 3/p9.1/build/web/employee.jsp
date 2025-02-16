<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Insert Employee</title>
</head>
<body>
    <h1>Samruddhi Surve</h1>
    <h2>Employee Insertion Status</h2>
    <%
        String employeeIdStr = request.getParameter("employee_id");  // Make sure this matches the form field name
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String department = request.getParameter("department");
        String position = request.getParameter("position");
        String salaryStr = request.getParameter("salary");
        out.println("<p>Employee ID: " + employeeIdStr + "</p>");
        String dbUrl = "jdbc:mysql://localhost:3306/sys?useSSL=false";
        String dbUser = "root";  // Change to your MySQL username
        String dbPassword = "vivek";  // Change to your MySQL password
        Connection conn = null;
        PreparedStatement pst = null;
        double salary = 0.0; // Default salary in case of an error
        int employeeId = 0; // Default employeeId

        try {
            // Ensure the MySQL JDBC Driver is loaded
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");  // Ensure the MySQL driver is loaded
            } catch (ClassNotFoundException e) {
                out.println("<p>Error: MySQL JDBC Driver not found!</p>");
                return;
            }

            // Check if salaryStr is not null and not empty
            if (salaryStr != null && !salaryStr.trim().isEmpty()) {
                salary = Double.parseDouble(salaryStr);
            } else {
                out.println("<p>Invalid salary input. Please enter a valid number.</p>");
                return; // Stop further processing if salary is invalid
            }

            // Check if employeeIdStr is not null and valid
            if (employeeIdStr != null && !employeeIdStr.trim().isEmpty()) {
                employeeId = Integer.parseInt(employeeIdStr);
            } else {
                out.println("<p>Invalid employee ID input. Please enter a valid employee ID.</p>");
                return;
            }
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);  // Get connection

            String sql = "INSERT INTO employee (id, first_name, last_name, department, position, salary) VALUES (?, ?, ?, ?, ?, ?)";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, employeeId);  // Manually set employee_id
            pst.setString(2, firstName);
            pst.setString(3, lastName);
            pst.setString(4, department);
            pst.setString(5, position);
            pst.setDouble(6, salary);
            int result = pst.executeUpdate();
            if (result > 0) {
                out.println("<p>Employee " + firstName + " " + lastName + " with ID " + employeeId + " was inserted successfully!</p>");
            } else {
                out.println("<p>Failed to insert the employee.</p>");
            }

        } catch (Exception e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    %>

</body>
</html>
