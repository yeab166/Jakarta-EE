<!DOCTYPE html>
<html>
<head>
    <title>Attendance System</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<div class="container">

<h2>Create Session</h2>
<form action="create" method="post">
    <input type="number" name="duration" placeholder="Duration (minutes)" required>
    <button type="submit">Create Session</button>
</form>

<hr>

<h2>View Attendance</h2>
<form action="view" method="post">
    <input type="text" name="code" placeholder="Enter Code" required>
    <button type="submit">View</button>
</form>

<a href="mark.jsp">Go to Student Page</a>

</div>

</body>
</html>