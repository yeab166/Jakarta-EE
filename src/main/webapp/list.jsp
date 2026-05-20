<%@ page import="java.util.List" %>
<%@ page import="com.attendance.model.Student" %>

<html>
<head>
    <title>Attendance List</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<div class="container">

<h2>Attendance List</h2>

<table>
<tr>
    <th>ID</th>
    <th>Name</th>
</tr>

<%
List<Student> students = (List<Student>) request.getAttribute("students");

if (students != null && !students.isEmpty()) {
    for (Student s : students) {
%>
<tr>
    <td><%= s.getId() %></td>
    <td><%= s.getName() %></td>
</tr>
<%
    }
} else {
%>
<tr><td colspan="2">No students found</td></tr>
<%
}
%>

</table>

<p class="total">Total Students: <b>${total}</b></p>

<a href="index.jsp">Back</a>

</div>

</body>
</html>