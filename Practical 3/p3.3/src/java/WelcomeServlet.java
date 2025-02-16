import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
response.setContentType("text/html");
PrintWriter out = response.getWriter();
out.println("<html><body>");
out.println("<h2>Welcome!</h2>");
out.println("<p>You have successfully logged in.</p>");
out.println("</body></html>");
out.close();
}
}
