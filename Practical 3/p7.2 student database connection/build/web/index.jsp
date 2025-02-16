<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Check MySQL Connection</title>
</head>
<body>
    <h2>MySQL Database Connection Status</h2>
    <h3>5358 Samruddhi Surve</h3>
    <%
        String url = "jdbc:mysql://localhost:3306/?user=root&useSSL=false&serverTImezone=UTC";
        String username = "root";
        String password = "vivek";
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {
                out.println("<p style='color: green;'>Connection to MySQL database established successfully!</p>");
            } else {
                out.println("<p style='color: red;'>Connection to MySQL database failed. Connection object is null!</p>");
            }
        } catch (ClassNotFoundException e) {
            out.println("<p style='color: red;'>Error: MySQL JDBC Driver not found! " + e.getMessage() + "</p>");
        } catch (SQLException e) {
            out.println("<p style='color: red;'>Error: Unable to establish connection! " + e.getMessage() + "</p>");
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                    out.println("<p>Database connection closed.</p>");
                } catch (SQLException e) {
                    out.println("<p style='color: red;'>Error closing connection: " + e.getMessage() + "</p>");
                }
            }
        }
    %>
</body>
</html>
