package topic4_tomcat;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

@WebServlet("/info")
public class InfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Request Info</h2>");
        out.println("<p>Method " +request.getMethod()+"</p>");
        out.println("<p>URI " +request.getRequestURI()+"</p>");
        out.println("<p>Client IP: " + request.getRemoteAddr() + "</p>");
        out.println("</body></html>");

    }
}
