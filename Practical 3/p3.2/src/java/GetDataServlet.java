import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/GetDataServlet")
public class GetDataServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
ServletContext context = getServletContext();
String sharedData = (String) context.getAttribute("sharedData");
response.setContentType("text/html");
PrintWriter out = response.getWriter();
out.println("<html><body>");
out.println("<h2>Retrieved Data from ServletContext</h2>");
if (sharedData != null) {out.println("<p>Shared Data: " + sharedData + "</p>");
} else {out.println("<p>No data found in ServletContext!</p>");}
out.println("</body></html>");
}
}
