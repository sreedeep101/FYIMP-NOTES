<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Student Information</title>
</head>
<body>

    <h2>Student Information</h2>

    <%
        String name = "Arun";
        int rollNo = 101;
        String course = "BCA";
        double mark = 85.5;
    %>

    <p><b>Name:</b> <%= name %></p>
    <p><b>Roll Number:</b> <%= rollNo %></p>
    <p><b>Course:</b> <%= course %></p>
    <p><b>Mark:</b> <%= mark %></p>

    <h3>Result</h3>

    <%
        if (mark >= 40) {
            out.println("<p>Result: Passed</p>");
        } else {
            out.println("<p>Result: Failed</p>");
        }
    %>

</body>
</html>
