import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet("/FileDownloadServlet")
public class fileID extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/sys?useSSL=false";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "vivek";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fileId = request.getParameter("id");
        if (fileId == null || fileId.isEmpty()) {
            response.getWriter().println("<h3>Invalid file ID!</h3>");
            return;
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                 PreparedStatement pstmt = conn.prepareStatement("SELECT file_name, file_data FROM files WHERE id = ?")) {
                pstmt.setInt(1, Integer.parseInt(fileId));
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        // Get file name and data
                        String fileName = rs.getString("file_name");
                        InputStream fileData = rs.getBinaryStream("file_data");
                        response.setContentType("application/octet-stream");
                        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
                        OutputStream out = response.getOutputStream();
                        byte[] buffer = new byte[4096];
                        int bytesRead;
                        while ((bytesRead = fileData.read(buffer)) != -1) {
                            out.write(buffer, 0, bytesRead);
                        }
                        fileData.close();
                        out.close();
                    } else {
                        response.getWriter().println("<h3>File not found!</h3>");
                    }
                }
            }

        } catch (ClassNotFoundException e) {
            response.getWriter().println("<h3>JDBC Driver not found!</h3>");
            e.printStackTrace();
        } catch (SQLException e) {
            response.getWriter().println("<h3>Database error: " + e.getMessage() + "</h3>");
            e.printStackTrace();
        }
    }
}
