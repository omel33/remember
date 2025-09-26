package topic4_tomcat;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/forward-demo")
public class ForwardDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setAttribute("message", "Hello from ForwardDemoServlet!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/message.jsp");
        dispatcher.forward(request, response);
    }
}
