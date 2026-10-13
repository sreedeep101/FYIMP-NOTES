<%@ page import="java.util.List" %>
<%@ page import="com.student.model.Student" %>

<%
    List<Student> students =
        (List<Student>) request.getAttribute("students");

    Student student =
        (Student) request.getAttribute("student");

    String context = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Student Management System</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
            background: #f4f6f9;
        }

        h1, h2 {
            color: #243b55;
        }

        .container {
            max-width: 1000px;
            margin: auto;
        }

        .box {
            background: white;
            padding: 20px;
            margin-bottom: 25px;
            border-radius: 8px;
            box-shadow: 0 2px 6px #ccc;
        }

        input {
            display: block;
            width: 95%;
            padding: 10px;
            margin: 10px 0;
        }

        button {
            padding: 10px 18px;
            background: #1769aa;
            color: white;
            border: none;
            cursor: pointer;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background: white;
        }

        th, td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: left;
        }

        th {
            background: #243b55;
            color: white;
        }

        a {
            margin-right: 10px;
        }
    </style>
</head>

<body>

<div class="container">

    <h1>Student Management System</h1>

    <div class="box">

        <% if (student == null) { %>

            <h2>Add Student</h2>

            <form action="<%= context %>/students" method="post">

                <input type="hidden"
                       name="action"
                       value="add">

                <input type="text"
                       name="name"
                       placeholder="Student Name"
                       maxlength="100"
                       required>

                <input type="email"
                       name="email"
                       placeholder="Email"
                       maxlength="100"
                       required>

                <input type="text"
                       name="course"
                       placeholder="Course"
                       maxlength="100"
                       required>

                <button type="submit">Add Student</button>

            </form>

        <% } else { %>

            <h2>Update Student</h2>

            <form action="<%= context %>/students" method="post">

                <input type="hidden"
                       name="action"
                       value="update">

                <input type="hidden"
                       name="id"
                       value="<%= student.getId() %>">

                <input type="text"
                       name="name"
                       value="<%= student.getName() %>"
                       maxlength="100"
                       required>

                <input type="email"
                       name="email"
                       value="<%= student.getEmail() %>"
                       maxlength="100"
                       required>

                <input type="text"
                       name="course"
                       value="<%= student.getCourse() %>"
                       maxlength="100"
                       required>

                <button type="submit">Update Student</button>

                <a href="<%= context %>/students">Cancel</a>

            </form>

        <% } %>

    </div>

    <div class="box">

        <h2>Student Records</h2>

        <table>

            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Course</th>
                <th>Actions</th>
            </tr>

            <% if (students != null && !students.isEmpty()) { %>

                <% for (Student s : students) { %>

                    <tr>

                        <td><%= s.getId() %></td>

                        <td><%= s.getName() %></td>

                        <td><%= s.getEmail() %></td>

                        <td><%= s.getCourse() %></td>

                        <td>
                            <a href="<%= context %>/students?action=edit&id=<%= s.getId() %>">
                                Edit
                            </a>

                            <a href="<%= context %>/students?action=delete&id=<%= s.getId() %>"
                               onclick="return confirm('Delete this student?');">
                                Delete
                            </a>
                        </td>

                    </tr>

                <% } %>

            <% } else { %>

                <tr>
                    <td colspan="5">No students found.</td>
                </tr>

            <% } %>

        </table>

    </div>

</div>

</body>
</html>
