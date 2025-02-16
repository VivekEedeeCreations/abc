import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fibonacci")
public class fibonacci extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Retrieve the input parameter 'n' from the request
        String nStr = request.getParameter("number");
        int n;
        
        try {
            // Convert the input parameter to an integer
            n = Integer.parseInt(nStr);
        } catch (NumberFormatException e) {
            out.println("<h2>Please provide a valid number.</h2>");
            return;
        }
        
        // Generate Fibonacci series
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Fibonacci Series Generator</title>");
        out.println("</head>");
        out.println("<body>");
        
        out.println("<h2>Fibonacci Series for " + n + " terms:</h2>");
        out.println("<p>");
        
        int firstTerm = 0, secondTerm = 1;
        out.print(firstTerm);
        
        if (n > 1) {
            out.print(", " + secondTerm);
            for (int i = 2; i < n; i++) {
                int nextTerm = firstTerm + secondTerm;
                out.print(", " + nextTerm);
                firstTerm = secondTerm;
                secondTerm = nextTerm;
            }
        }
        
        out.println("</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
