
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<body>
<h2>All Employees in System</h2>

<table border="1">
    <tr>
        <th>Employee Id</th>
        <th> Name</th>

    </tr>
    <c:forEach items="${empList}" var="employee">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>

        </tr>
    </c:forEach>
</table>

</body>
</html>
