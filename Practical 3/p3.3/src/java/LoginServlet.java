import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
response.setContentType("text/html");
PrintWriter out = response.getWriter();
out.println("<html><body>");
String password = request.getParameter("password");
if ("Servlet".equals(password)) {
RequestDispatcher dispatcher = request.getRequestDispatcher("WelcomeServlet");
dispatcher.forward(request, response);
} else {
out.println("<h2>Login Failed</h2>");
out.println("<p>Incorrect password. Please try again.</p>");
out.println("<a href='index.html'>Back to Login Page</a>");
}
out.println("</body></html>");
out.close();
}
}
