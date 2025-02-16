import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/SetDataServlet")
public class SetDataServlet extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
ServletContext context = getServletContext();
String sharedData = request.getParameter("sharedData");
context.setAttribute("sharedData", sharedData);
response.setContentType("text/html");
PrintWriter out = response.getWriter();
out.println("<html><body>");
out.println("<h2>Data has been set in ServletContext!</h2>");
out.println("<p>Shared Data: " + sharedData + "</p>");
out.println("<a href='GetDataServlet'>Go to GetDataServlet</a>");
out.println("</body></html>");}}

