package topic4_tomcat;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name =( String) session.getAttribute("username");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if(name==null){
            out.println("<h2>Login</h2>");
            out.println("<form method='post' action='/login'>");
            out.println("Name: <input type='text' name='username' />");
            out.println("<input type='submit' value='Login' />");
            out.println("</form>");
        }else {
            out.println("<h2>Welcome back, " + name + "!</h2>");
            out.println("<form method='get' action='/logout'>");
            out.println("<input type='submit' value='Logout' />");
            out.println("</form>");
        }
        out.println("</body></html>");

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("username");

        HttpSession session = request.getSession();
        session.setAttribute("username", name);
        response.sendRedirect("/login");
    }
}
