<%@ page import="beans.Student" %>

<!DOCTYPE html>
<html>
<head>
    <title>Student Details</title>
</head>
<body>

    <jsp:include page="header.jsp" />

    <jsp:useBean id="student"
                 class="beans.Student"
                 scope="request" />

    <jsp:setProperty name="student"
                     property="name"
                     value="Arun" />

    <jsp:setProperty name="student"
                     property="mark"
                     value="85" />

    <h3>Student Details</h3>

    <p>Name:
        <jsp:getProperty name="student" property="name" />
    </p>

    <p>Mark:
        <jsp:getProperty name="student" property="mark" />
    </p>

    <a href="index.jsp">Back to Home</a>

</body>
</html>
