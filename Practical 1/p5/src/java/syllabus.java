
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class syllabus extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Syllabus</title>");
            out.println("<style>");
            out.println("body{font-family:Arial,sans-serif;background-color:#f4f4f9;margin:0;padding:20px;}");
            out.println("h1 {color:#333;}");
            out.println("ul{font-size:18px;line-height:1.6;}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>SYCS Syllabus</h1>");
            out.println("<h2>Course Outcome</h2>");
            out.println("<p>This course provides introduction</p>");
            out.println("<h3>Topics covered</h3>");
            out.println("<ul>");
            out.println("<li>Intro to software</li>");
            out.println("<li>Requirements</li>");
            out.println("<li>Design</li>");
            out.println("<li>hi</li>");
            out.println("</ul>");
            out.println("<h3>Grading</h3>");
            out.println("<ul>");
            out.println("<li>Assignments</li>");
            out.println("<li>Midterm Exam</li>");
            out.println("<li>finsl</li>");
            out.println("</body>");

            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
