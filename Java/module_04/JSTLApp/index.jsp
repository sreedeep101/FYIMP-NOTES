<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSTL Student Marks</title>
</head>
<body>

    <h2>Student Marks Application</h2>

    <c:set var="name" value="Arun"/>
    <c:set var="mark" value="85"/>
    <c:set var="average" value="83.456"/>

    <h3>Student Details</h3>

    <p>Name: <c:out value="${name}"/></p>
    <p>Mark: <c:out value="${mark}"/></p>

    <h3>1. Conditional Tag: c:if</h3>

    <c:if test="${mark >= 40}">
        <p>Result: Passed</p>
    </c:if>

    <c:if test="${mark < 40}">
        <p>Result: Failed</p>
    </c:if>

    <h3>2. Choose, When and Otherwise</h3>

    <c:choose>
        <c:when test="${mark >= 80}">
            <p>Grade: A</p>
        </c:when>

        <c:when test="${mark >= 60}">
            <p>Grade: B</p>
        </c:when>

        <c:when test="${mark >= 40}">
            <p>Grade: C</p>
        </c:when>

        <c:otherwise>
            <p>Grade: F</p>
        </c:otherwise>
    </c:choose>

    <h3>3. Iteration: c:forEach</h3>

    <c:forEach var="i" begin="1" end="5">
        <p>Subject ${i}</p>
    </c:forEach>

    <h3>4. Formatting: fmt:formatNumber</h3>

    <p>Average:
        <fmt:formatNumber value="${average}" pattern="#,##0.00"/>
    </p>

</body>
</html>
