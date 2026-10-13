import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/protected")
public class ProtectedServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        // Check whether the user has an authenticated session
        HttpSession session = request.getSession(false);

        if (session == null ||
            session.getAttribute("username") == null) {

            // User is not authenticated
            response.sendRedirect(
                request.getContextPath() + "/index.html"
            );

            return;
        }

        // User is authenticated
        String username = (String) session.getAttribute("username");

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Welcome, " + username + "!</h2>");
        out.println("<p>You have successfully logged in.</p>");
        out.println("<p>This is a protected resource.</p>");
        out.println("<a href='logout'>Logout</a>");
        out.println("</body></html>");
    }
}
