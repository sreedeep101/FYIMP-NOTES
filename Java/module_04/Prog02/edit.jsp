<%@ page import="com.student.Student" %>

<html>
<body>

<h2>Update Student</h2>

<%
Student s = (Student) request.getAttribute("student");
%>

<% if (s != null) { %>

<form action="students" method="post">

    <input type="hidden" name="action" value="update">

    <input type="hidden" name="id"
           value="<%= s.getId() %>">

    Name:
    <input type="text" name="name"
           value="<%= s.getName() %>" required>
    <br><br>

    Email:
    <input type="email" name="email"
           value="<%= s.getEmail() %>" required>
    <br><br>

    <input type="submit" value="Update Student">

</form>

<% } else { %>

<p>Student not found.</p>

<% } %>

<br>

<a href="students">Back to Student List</a>

</body>
</html>
