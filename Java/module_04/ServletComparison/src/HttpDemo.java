import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/http")
public class HttpDemo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>HttpServlet Demonstration</h2>");
        out.println("<p>This servlet extends HttpServlet.</p>");
        out.println("<p>It overrides the doGet() method.</p>");
        out.println("<p>HttpServlet is designed for HTTP.</p>");
        out.println("</body></html>");
    }
}
