import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/vote-checker")
public class vote extends HttpServlet {
       protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve the input parameter 'age' from the request
        String ageStr = request.getParameter("number");
        int age;
        try {
            // Convert the input parameter to an integer
            age = Integer.parseInt(ageStr);
        } catch (NumberFormatException e) {
            out.println("<h2>Please provide a valid age.</h2>");
            return;
        }

        // Check if the age is eligible to vote
        String message;
        if (age >= 18) {
            message = "You are eligible to cast your vote.";
        } else {
            message = "You are not eligible to vote yet. Please wait until you turn 18.";
        }

        // Generate HTML response
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Vote Eligibility Checker</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Vote Eligibility Checker</h2>");
        out.println("<p>" + message + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
