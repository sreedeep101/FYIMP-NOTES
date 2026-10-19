<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<%!
    // Declaration: variables and method
    int mark1 = 85;
    int mark2 = 90;
    int mark3 = 75;

    int calculateTotal() {
        return mark1 + mark2 + mark3;
    }

    double calculateAverage() {
        return calculateTotal() / 3.0;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Student Marks</title>
</head>
<body>

    <h2>Student Mark Details</h2>

    <p>Subject 1 Mark: <%= mark1 %></p>
    <p>Subject 2 Mark: <%= mark2 %></p>
    <p>Subject 3 Mark: <%= mark3 %></p>

    <hr>

    <p>Total Marks: <%= calculateTotal() %></p>
    <p>Average Marks: <%= calculateAverage() %></p>

</body>
</html>
