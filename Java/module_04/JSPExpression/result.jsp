<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Student Result</title>
</head>
<body>

    <h2>Student Information</h2>

    <jsp:useBean id="student"
                 class="beans.Student"
                 scope="request" />

    <jsp:setProperty name="student" property="*" />

    <p>Name: ${student.name}</p>

    <p>Course: ${student.course}</p>

    <p>Mark: ${student.mark}</p>

    <h3>Result</h3>

    <p>
        ${student.mark >= 40 ? 'Passed' : 'Failed'}
    </p>

    <h3>Request Information</h3>

    <p>Submitted Name: ${param.name}</p>

    <p>Submitted Course: ${param.course}</p>

    <p>Submitted Mark: ${param.mark}</p>

    <a href="index.jsp">Back to Form</a>

</body>
</html>
