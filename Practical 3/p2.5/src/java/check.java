import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet("/checkNumber") // Maps to the URL pattern /checkNumber
public class check extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Get the number from the request
        String numberStr = request.getParameter("number");
        double number = Double.parseDouble(numberStr);
        
        // Determine if the number is positive, negative, or zero
        String result;
        if (number > 0) {
            result = "The number is positive.";
        } else if (number < 0) {
            result = "The number is negative.";
        } else {
            result = "The number is zero.";
        }
        
        // Generate HTML response
        out.println("<html><body>");
        
        out.println("<h1>Result</h1>");
        out.println("<p>" + result + "</p>");
        out.println("<a href='index.html'>Go back</a>");
        out.println("</body></html>");
        out.close();
    }
}
