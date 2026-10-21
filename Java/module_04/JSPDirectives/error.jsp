<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
    <title>Error Page</title>
</head>
<body>

    <h2>An Error Occurred!</h2>

    <p>Sorry, an unexpected error occurred.</p>

    <p>Error Details: <%= exception.getMessage() %></p>

    <a href="index.jsp">Return to Home Page</a>

</body>
</html>
