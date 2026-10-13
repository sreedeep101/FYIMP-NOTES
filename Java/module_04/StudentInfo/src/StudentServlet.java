import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Student Information</title>");
        out.println("</head>");

        out.println("<body>");
        out.println("<h1>Student Information</h1>");

        out.println("<p><b>Roll Number:</b> 101</p>");
        out.println("<p><b>Name:</b> Arun Kumar</p>");
        out.println("<p><b>Course:</b> BCA</p>");
        out.println("<p><b>College:</b> Kannur University</p>");

        out.println("</body>");
        out.println("</html>");
    }
}