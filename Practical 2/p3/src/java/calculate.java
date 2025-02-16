/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author heshi
 */
public class calculate extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
           int num1=Integer.parseInt(request.getParameter("num1")) ;
           int num2=Integer.parseInt(request.getParameter("num2")) ;
           String operation=request.getParameter("operation");
           int result=0;
           String operator="";
           switch(operation){
               case "Add":
                   result=num1+num2;
                   operator="+";
                   break;
               case "Sub":
                   result=num1-num2;
                   operator="-";
                   break;
               case "Mul":
                   result=num1*num2;
                   operator="x";
                   break;
               case "Div":
                   if(num2!=0){
                   result=num1/num2;
                   operator="/";
           }
           else{
                   response.setContentType("text/html");
                   PrintWriter out=response.getWriter();
                   out.println("<html><head><title>Error</title></head><body>");
                   out.println("<h2>Error:Division by zero</h2>");
                   out.println("</body></html>");
                   return;
                   
                   
                   }
           break;
          
        }
       response.setContentType("text/html");
                   PrintWriter out=response.getWriter();
                   out.println("<html><head><title>Result</title></head><body>");
                   out.println("<h2>Result:</h2>") ;
                   out.println("<p>"+num1+""+operator+""+num2+"="+result+"</p>");
                   out.println("</body></html>");
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
