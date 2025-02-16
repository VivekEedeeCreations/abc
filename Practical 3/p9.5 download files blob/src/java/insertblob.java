import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet("/BlobInsertionServlet")
@MultipartConfig(maxFileSize = 16177215) // 16MB limit
public class insertblob extends HttpServlet {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/sys?useSSL=false";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "vivek";
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        String username = request.getParameter("username"); // Get username
        Part filePart = request.getPart("file"); // Get uploaded file
        if (filePart == null || filePart.getSize() == 0 || username == null || username.isEmpty()) {
            response.getWriter().println("<h3>Invalid input. Please provide a username and a file.</h3>");
            return;
       }
        String fileName = filePart.getSubmittedFileName();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            response.getWriter().println("<h3>MySQL JDBC Driver not found!</h3>");
            return;
        }
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             InputStream fileContent = filePart.getInputStream();
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO files (username, file_name, file_data) VALUES (?, ?, ?)")
        ) {
            pstmt.setString(1, username);
            pstmt.setString(2, fileName);
            pstmt.setBinaryStream(3, fileContent, filePart.getSize());
            int rows = pstmt.executeUpdate();
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            if (rows > 0) {
                out.println("<h3>Samruddhi Surve 5358</h3>");
                out.println("<h3>File uploaded successfully!</h3>");
            } else {
                out.println("<h3>File upload failed.</h3>");
            }} catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("<h3>Database error: " + e.getMessage() + "</h3>");
        }}}
