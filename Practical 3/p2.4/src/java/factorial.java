import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/factorial")
public class factorial extends HttpServlet {
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve the input parameter 'number' from the request
        String numberStr = request.getParameter("number");
        int number;
        try {
            // Convert the input parameter to an integer
            number = Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            out.println("<h2>Please provide a valid number.</h2>");
            return;
        }

        // Calculate factorial of the number
        int factorial = calculateFactorial(number);

        // Generate HTML response
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Factorial Calculator Result</title>");
        out.println("</head>");
        out.println("<body>");
        
        out.println("<h2>Factorial of " + number + " is: " + factorial + "</h2>");
        out.println("</body>");
        out.println("</html>");
    }

    // Method to calculate factorial recursively
    private int calculateFactorial(int n) {
        if (n == 0)
            return 1;
        else
            return n * calculateFactorial(n - 1);
    }
}
