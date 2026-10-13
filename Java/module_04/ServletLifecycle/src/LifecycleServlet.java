import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/lifecycle")
public class LifecycleServlet extends HttpServlet {

    // Called once when the servlet is initialized
    @Override
    public void init() throws ServletException {
        System.out.println("init() method executed");
    }

    // Called for every request
    @Override
    public void service(HttpServletRequest request,
                        HttpServletResponse response)
                        throws ServletException, IOException {

        System.out.println("service() method executed");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Servlet Life-Cycle Demonstration</h2>");
        out.println("<p>init() method: Initializes the servlet.</p>");
        out.println("<p>service() method: Handles client requests.</p>");
        out.println("<p>destroy() method: Destroys the servlet.</p>");
        out.println("</body></html>");
    }

    // Called once when the servlet is taken out of service
    @Override
    public void destroy() {
        System.out.println("destroy() method executed");
    }
}