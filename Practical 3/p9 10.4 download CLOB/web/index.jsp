<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Download Files</title>
</head>
<body>
    <h1>Samruddhi Surve 5358</h1>
    <h2>Available Files for Download</h2>
    <table border="1">
        <tr>
            <th>File ID</th>
            <th>Username</th>
            <th>File Name</th>
            <th>Download</th>
        </tr>
        <%
            try {
                // Load MySQL JDBC Driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Establish Connection
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?useSSL=false", "root", "vivek");
                
                // Prepare SQL Query
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT id, username, file_name FROM text_files");

                // Iterate through results and display files
                while (rs.next()) {
                    int fileId = rs.getInt("id");
                    String username = rs.getString("username");
                    String fileName = rs.getString("file_name");
        %>
        <tr>
            <td><%= fileId %></td>
            <td><%= username %></td>
            <td><%= fileName %></td>
            <td><a href="filesDownload?id=<%= fileId %>">Download</a></td>
        </tr>
        <%
                }
                // Close connection
                conn.close();
            } catch (Exception e) {
                out.println("<h3>Error: " + e.getMessage() + "</h3>");
            }
        %>
    </table>
</body>
</html>

