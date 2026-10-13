import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/student")
public class FormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        // Read parameters from the HTML form
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String course = request.getParameter("course");
        String email = request.getParameter("email");

        // Validate the submitted values
        if (name == null || name.trim().isEmpty()
                || age == null || age.trim().isEmpty()
                || course == null || course.trim().isEmpty()
                || email == null || email.trim().isEmpty()) {

            response.sendError(
                HttpServletResponse.SC_BAD_REQUEST,
                "All fields are required."
            );
            return;
        }

        // Validate age
        try {
            if (Integer.parseInt(age) < 1) {
                response.sendError(
                    HttpServletResponse.SC_BAD_REQUEST,
                    "Age must be greater than zero."
                );
                return;
            }
        } catch (NumberFormatException e) {
            response.sendError(
                HttpServletResponse.SC_BAD_REQUEST,
                "Please enter a valid age."
            );
            return;
        }

        // Set response type
        response.setContentType("text/html;charset=UTF-8");

        // Generate the HTML response
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Student Details</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h2>Student Registration Successful</h2>");

        out.println("<p><b>Name:</b> "
                + escapeHtml(name) + "</p>");

        out.println("<p><b>Age:</b> "
                + escapeHtml(age) + "</p>");

        out.println("<p><b>Course:</b> "
                + escapeHtml(course) + "</p>");

        out.println("<p><b>Email:</b> "
                + escapeHtml(email) + "</p>");

        out.println("<br><a href='index.html'>Go Back</a>");

        out.println("</body>");
        out.println("</html>");
    }

    // Escape user input before displaying it as HTML
    private String escapeHtml(String value) {
        return value.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&#39;");
    }
}
