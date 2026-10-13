import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/generic")
public class GenericDemo extends GenericServlet {

    @Override
    public void service(ServletRequest request,
                        ServletResponse response)
                        throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>GenericServlet Demonstration</h2>");
        out.println("<p>This servlet extends GenericServlet.</p>");
        out.println("<p>It overrides the service() method.</p>");
        out.println("<p>GenericServlet is protocol-independent.</p>");
        out.println("</body></html>");
    }
}
