import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        // Get the existing session without creating a new one
        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }

        // Return to the login page
        response.sendRedirect(
            request.getContextPath() + "/index.html"
        );
    }
}
