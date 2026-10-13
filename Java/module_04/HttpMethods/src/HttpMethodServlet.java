import java.io.*;
import java.nio.charset.StandardCharsets;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/httpmethods")
public class HttpMethodServlet extends HttpServlet {

    // Handles GET requests
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        String name = request.getParameter("name");

        if (name == null || name.trim().isEmpty()) {
            name = "Guest";
        }

        String html = createResponse("GET", name);

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.setContentLength(
            html.getBytes(StandardCharsets.UTF_8).length
        );

        PrintWriter out = response.getWriter();
        out.println(html);
    }

    // Handles POST requests
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");

        if (name == null || name.trim().isEmpty()) {
            name = "Guest";
        }

        String html = createResponse("POST", name);

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.setContentLength(
            html.getBytes(StandardCharsets.UTF_8).length
        );

        PrintWriter out = response.getWriter();
        out.println(html);
    }

    // Handles HEAD requests without sending a response body
    @Override
    protected void doHead(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        String name = request.getParameter("name");

        if (name == null || name.trim().isEmpty()) {
            name = "Guest";
        }

        String html = createResponse("GET", name);

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        // Set the length of the body that GET would return
        response.setContentLength(
            html.getBytes(StandardCharsets.UTF_8).length
        );

        response.setHeader("X-Request-Method", "HEAD");

        // Do not write a response body for HEAD
    }

    // Creates the HTML response
    private String createResponse(String method, String name) {

        return "<html><body>"
             + "<h2>HTTP Method Demonstration</h2>"
             + "<p>Request Method: " + method + "</p>"
             + "<p>Welcome, " + escapeHtml(name) + "!</p>"
             + "</body></html>";
    }

    // Escapes user input before inserting it into HTML
    private String escapeHtml(String value) {
        return value.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&#39;");
    }
}
