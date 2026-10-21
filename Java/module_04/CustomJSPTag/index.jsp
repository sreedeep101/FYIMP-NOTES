<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/WEB-INF/tld/student.tld" %>

<!DOCTYPE html>
<html>
<head>
    <title>Custom JSP Tag</title>
</head>
<body>

    <h2>Custom JSP Tag Demonstration</h2>

    <s:studentInfo
        name="Arun"
        course="BCA"
        mark="85" />

    <hr>

    <s:studentInfo
        name="Rahul"
        course="BSc Computer Science"
        mark="32" />

</body>
</html>
