import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/error-demo")
public class ErrorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        // Intentionally generate an error
        throw new ArithmeticException(
            "Intentional arithmetic error for demonstration"
        );
    }
}
