<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Salary Status</title>
</head>
<body>
    <h1>Samruddhi</h1>
    <h2>Employee Salary Update Status</h2>
    <%
        String employeeIdStr = request.getParameter("employee_id");
        String salaryStr = request.getParameter("salary");
        String dbUrl = "jdbc:mysql://localhost:3306/sys?useSSL=false";
        String dbUser = "root";  // Change to your MySQL username
        String dbPassword = "vivek";  // Change to your MySQL password
        Connection conn = null;
        PreparedStatement pst = null;
        double salary = 0.0; // Default salary in case of an error
        int employeeId = 0; // Default employeeId
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                out.println("<p>Error: MySQL JDBC Driver not found!</p>");
                return;
            }
            if (salaryStr != null && !salaryStr.trim().isEmpty()) {
                salary = Double.parseDouble(salaryStr); // Parse salary to double
            } else {
                out.println("<p>Invalid salary input. Please enter a valid number.</p>");
                return;
            }
            if (employeeIdStr != null && !employeeIdStr.trim().isEmpty()) {
                employeeId = Integer.parseInt(employeeIdStr); // Parse employee_id to integer
            } else {
                out.println("<p>Invalid employee ID input. Please enter a valid employee ID.</p>");
                return;
            }
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);  // Get connection
            String sql = "UPDATE employee SET salary = ? WHERE id = ?";
            pst = conn.prepareStatement(sql);
            pst.setDouble(1, salary);  // Set new salary
            pst.setInt(2, employeeId); // Set employee_id
            int result = pst.executeUpdate();
            if (result > 0) {
                out.println("<p>Salary for Employee with ID " + employeeId + " has been successfully updated to " + salary + "!</p>");
            } else {
                out.println("<p>Failed to update the salary. Please check the employee ID.</p>");
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
