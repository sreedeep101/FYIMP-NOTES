import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Check the login credentials
        if ("admin".equals(username) && "1234".equals(password)) {

            // Create a session after successful login
            HttpSession session = request.getSession(true);

            // Store the authenticated user's username
            session.setAttribute("username", username);

            // Redirect to the protected resource
            response.sendRedirect(
                request.getContextPath() + "/protected"
            );

        } else {

            // Invalid credentials
            response.setContentType("text/html;charset=UTF-8");

            PrintWriter out = response.getWriter();

            out.println("<html><body>");
            out.println("<h2>Login Failed!</h2>");
            out.println("<p>Invalid username or password.</p>");
            out.println("<a href='index.html'>Try Again</a>");
            out.println("</body></html>");
        }
    }
}
