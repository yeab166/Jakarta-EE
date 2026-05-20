<!DOCTYPE html>
<html>
<head>
    <title>Mark Attendance</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<div class="container">

<h2>Mark Attendance</h2>

<form action="mark" method="post">
    <input type="text" name="name" placeholder="Name" required>
    <input type="text" name="id" placeholder="Student ID" required>
    <input type="text" name="code" placeholder="Session Code" required>
    <button type="submit">Mark Attendance</button>
</form>

<a href="index.jsp">Back</a>

</div>

</body>
</html>