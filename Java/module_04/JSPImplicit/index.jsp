<%@ page contentType="text/html;charset=UTF-8" errorPage="error.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP Implicit Objects</title>
</head>
<body>

    <h2>JSP Implicit Objects</h2>

    <%
        // request object
        String name = request.getParameter("name");
        if (name == null) {
            name = "Student";
        }

        // response object
        response.setHeader("X-JSP-Demo", "ImplicitObjects");

        // session object
        session.setAttribute("username", name);

        // application object
        application.setAttribute("college", "Kannur University");

        // config object
        String servletName = config.getServletName();

        // pageContext object
        pageContext.setAttribute("course", "BCA");

        // out object
        out.println("<p>Welcome, " + name + "!</p>");
    %>

    <p><b>Request:</b>
        <%= request.getMethod() %>
    </p>

    <p><b>Response:</b>
        Response content type is
        <%= response.getContentType() %>
    </p>

    <p><b>Session:</b>
        <%= session.getAttribute("username") %>
    </p>

    <p><b>Application:</b>
        <%= application.getAttribute("college") %>
    </p>

    <p><b>Config:</b>
        <%= config.getServletName() %>
    </p>

    <p><b>PageContext:</b>
        <%= pageContext.getAttribute("course") %>
    </p>

    <p><b>Out:</b> Used to print content to the browser.</p>

    <a href="index.jsp?name=Arun">Test with another name</a>
    <br><br>

    <a href="index.jsp?error=1">Test Exception Object</a>

    <%
        if ("1".equals(request.getParameter("error"))) {
            throw new RuntimeException("This is a test exception.");
        }
    %>

</body>
</html>
