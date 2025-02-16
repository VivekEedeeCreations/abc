import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/armstrong")
public class armstrong extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
       response.setContentType("text/html");
       PrintWriter out = response.getWriter();
        try {
            // Get the number from the request
            int number = Integer.parseInt(request.getParameter("number"));
            int originalNumber = number;
            int sum = 0;
            int n = String.valueOf(number).length(); // Get the number of digits

            // Calculate the sum of the powers of its digits
            while (number > 0) {
                int digit = number % 10;
                sum += Math.pow(digit, n);
                number /= 10;
            }
// Check if the number is an Armstrong number
            out.println("<h1>Result</h1>");
            if (sum == originalNumber) {
                out.println("<p>" + originalNumber + " is an Armstrong number.</p>");
            } else {
                out.println("<p>" + originalNumber + " is not an Armstrong number.</p>");
            }
        } catch (NumberFormatException e) {
            out.println("<p>Please enter a valid integer.</p>");
        } finally {
            out.close();
        }
    }
}
