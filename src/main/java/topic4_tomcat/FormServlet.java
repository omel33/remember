package topic4_tomcat;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/form")
public class FormServlet extends HttpServlet {

    @Override
    protected  void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       response.setContentType("text/html; charset=UTF-8");

       PrintWriter out = response.getWriter();
       out.println("<html><body>");
       out.println("<h2>Enter your message</h2>");
       out.println("<form method='post' action='/form'>");
       out.println("Message : <input type='text' name='msg' />");
       out.println("<input type='submit' value='Send' />");
       out.println("</form>");
       out.println("</body></html>");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String msg=request.getParameter("msg");
        if(msg==null||msg.isBlank()){
            msg = "Nothing was submitted!";
        }
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Form Result</h2>");
        out.println("<p>You submitted: " + msg + "</p>");
        out.println("<p>Method: " + request.getMethod() + "</p>");
        out.println("</body></html>");
    }


}
