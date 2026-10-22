<!DOCTYPE html>
<html>
<head>
    <title>Student Information</title>
</head>
<body>

    <h2>Enter Student Details</h2>

    <form action="result.jsp" method="post">

        Name:
        <input type="text" name="name" required>
        <br><br>

        Course:
        <input type="text" name="course" required>
        <br><br>

        Mark:
        <input type="number" name="mark" min="0" max="100" required>
        <br><br>

        <input type="submit" value="Submit">

    </form>

</body>
</html>

