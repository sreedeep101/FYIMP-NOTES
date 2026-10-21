import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("username");

        if (name != null && !name.trim().isEmpty()) {
            Cookie cookie = new Cookie("username", name.trim());
            cookie.setMaxAge(60 * 60 * 24); // 1 day
            cookie.setPath(request.getContextPath().isEmpty()
                           ? "/" : request.getContextPath());

            response.addCookie(cookie);
        }

        response.sendRedirect(request.getContextPath() + "/cookie");
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Saved User</title></head><body>");
        out.println("<h2>Saved User Information</h2>");

        Cookie[] cookies = request.getCookies();
        String name = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    name = cookie.getValue();
                    break;
                }
            }
        }

        if (name != null) {
            out.println("<p>Welcome back, " +
                escapeHtml(name) + "!</p>");
        } else {
            out.println("<p>No saved name found.</p>");
            out.println("<a href='index.html'>Enter your name</a>");
        }

        out.println("<br><a href='index.html'>Go Back</a>");
        out.println("</body></html>");
    }

    private String escapeHtml(String value) {
        return value.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&#39;");
    }
}
