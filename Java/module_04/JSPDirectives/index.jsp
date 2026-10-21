<%@ page import="java.util.Date,java.util.Calendar" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page errorPage="error.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP Directives</title>
</head>
<body>

    <h2>JSP Page Directive Attributes</h2>

    <%
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
    %>

    <p>Current Date and Time: <%= today %></p>

    <p>Current Year: <%= calendar.get(Calendar.YEAR) %></p>

    <p>Welcome to JSP Page Directives!</p>

    <a href="error.jsp">View Error Page</a>

</body>
</html>
