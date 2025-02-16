import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/prime-checker")
public class prime extends HttpServlet {
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

        // Check if the number is prime
        boolean isPrime = isPrimeNumber(number);

        // Generate HTML response
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Prime Number Checker</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Prime Number Checker</h2>");
        if (isPrime) {
            out.println("<p>" + number + " is a prime number.</p>");
        } else {
            out.println("<p>" + number + " is not a prime number.</p>");
        }
        out.println("</body>");
        out.println("</html>");
    }

    // Method to check if a number is prime
    private boolean isPrimeNumber(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
