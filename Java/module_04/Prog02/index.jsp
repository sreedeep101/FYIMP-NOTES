<%@ page import="java.util.*" %>
<%@ page import="com.student.Student" %>

<html>
<body>

<h2>Student Management</h2>

<h3>Add Student</h3>

<form action="students" method="post">

    <input type="hidden" name="action" value="add">

    Name:
    <input type="text" name="name" required>
    <br><br>

    Email:
    <input type="email" name="email" required>
    <br><br>

    <input type="submit" value="Add Student">

</form>

<hr>

<h3>Student List</h3>

<table border="1" cellpadding="8">

<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Email</th>
    <th>Action</th>
</tr>

<%
ArrayList<Student> list =
    (ArrayList<Student>) request.getAttribute("students");

if (list != null) {
    for (Student s : list) {
%>

<tr>
    <td><%= s.getId() %></td>
    <td><%= s.getName() %></td>
    <td><%= s.getEmail() %></td>

    <td>
        <a href="students?action=edit&id=<%= s.getId() %>">
            Edit
        </a>

        <form action="students" method="post"
              style="display:inline">

            <input type="hidden" name="action" value="delete">

            <input type="hidden" name="id"
                   value="<%= s.getId() %>">

            <input type="submit" value="Delete">
        </form>
    </td>
</tr>

<%
    }
}
%>

</table>

</body>
</html>
