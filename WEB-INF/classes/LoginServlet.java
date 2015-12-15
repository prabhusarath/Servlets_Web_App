/*
 * LoginServlet.java
 *
 */
 

import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
   
    public static Map users = new HashMap();
    /** 
     * Initializes the servlet with some usernames/password
    */  
    public void init() {


        users.put("Manager", "Manager");
		
    }

    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {

        String userid = request.getParameter("userid");
        String password = request.getParameter("password");

        if(userid != null && userid.length() != 0) {
            userid = userid.trim();
        }
        if(password != null && password.length() != 0) {
            password = password.trim();
        }
        if(userid != null &&
            password != null) {
                String realpassword = (String)users.get(userid);
                if(realpassword != null &&
                    realpassword.equals(password)) {

                    HttpSession session=request.getSession();  
                    session.setAttribute("username",userid);


                    showPage(response, "Login Success!! - Welcome Manager ");
                } else {
                    showPage1(response, "Login Failure! Username or password is incorrect");
                }
        }  else {
            showPage1(response, "Login Failure!  You must supply a username and password");
        }
    } 
    
    /**
     * Actually shows the <code>HTML</code> result page
     */
    protected void showPage(HttpServletResponse response, String message)
    throws ServletException, java.io.IOException {
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Login Servlet Result</title>");  
        out.println("</head>");
        out.println("<body>");
        out.println("<form action =\"ManagerProducts\">");
        out.println("<h2>" + message + "</h2>");
        out.println("<input type =\"submit\" value=\"ShowProducts\">");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
        out.close();
 
    }

    protected void showPage1(HttpServletResponse response, String message)
    throws ServletException, java.io.IOException {
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();

    
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Login Servlet Result</title>");  
        out.println("</head>");
        out.println("<body>");
        out.println("<form action =\"Loginm.html\">");
        out.println("<h2>" + message + "</h2>");
        out.println("<input type =\"submit\" value=\"View Manager Login \">");
        out.println("</form>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
        out.close();
 
    }
    
    /** Handles the HTTP <code>GET</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        processRequest(request, response);
    } 

    /** Handles the HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        processRequest(request, response);
    }
}
