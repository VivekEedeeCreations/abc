import java.io.*;
import static java.lang.System.out;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/ClobDownloadServlet")
public class filesDownload extends HttpServlet {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/sys?useSSL=false";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "vivek";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fileId = request.getParameter("id");
        out.println("<h1>Samruddhi Surve 5358</h1>");
        if (fileId == null || fileId.isEmpty()) {
            response.getWriter().println("<h3>Invalid file ID.</h3>");
            return;
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            response.getWriter().println("<h3>MySQL JDBC Driver not found!</h3>");
            return;
        }

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement("SELECT file_name, file_content FROM text_files WHERE id = ?")
        ) {
            pstmt.setInt(1, Integer.parseInt(fileId));
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String fileName = rs.getString("file_name");
                String fileContent = rs.getString("file_content");

                response.setContentType("text/plain");
                response.setHeader("Content-Disposition", "attachment; filename=" + fileName);

                PrintWriter out = response.getWriter();
                out.write(fileContent);
                out.flush();
            } else {
                response.getWriter().println("<h3>File not found.</h3>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("<h3>Database error: " + e.getMessage() + "</h3>");
        }
    }
}
