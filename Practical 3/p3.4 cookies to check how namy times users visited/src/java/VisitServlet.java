import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/VisitCounterServlet")
public class VisitServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
response.setContentType("text/html");
PrintWriter out = response.getWriter();
Cookie[] cookies = request.getCookies();
int visitCount = 0;
boolean isNewVisitor = true;
if (cookies != null) {
for (Cookie cookie : cookies) {
if ("visitCount".equals(cookie.getName())) {
visitCount = Integer.parseInt(cookie.getValue());
isNewVisitor = false;
}
}
}
visitCount++;
Cookie visitCookie = new Cookie("visitCount", String.valueOf(visitCount));
visitCookie.setMaxAge(60 * 60 * 24 * 365); // Cookie valid for 1 year
response.addCookie(visitCookie);
out.println("<html><body>");
out.println("<h1>Visit Counter</h1>");
if (isNewVisitor) {
out.println("<p>Welcome! This is your first visit to this servlet.</p>");
} else {
out.println("<p>You have visited this servlet " + visitCount + " times.</p>");
}
out.println("<a href='index.html'>Back to Home</a>");
out.println("</body></html>");
out.close();
}
}
