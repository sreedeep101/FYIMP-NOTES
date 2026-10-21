<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
    <title>Error Page</title>
</head>
<body>

    <h2>An Error Occurred</h2>

    <p>Error Message: <%= exception.getMessage() %></p>

    <a href="index.jsp">Return to Home Page</a>

</body>
</html>
