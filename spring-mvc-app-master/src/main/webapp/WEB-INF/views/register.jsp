<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Login</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style type="text/css">
        .error {
            color: red;
        }
    </style>
</head>
<body>
<div class="container">
    <h2 align="center" class="text-primary">Register</h2>
    <hr />
    <div> </div>

    <form:form action="/emp-mvc/employee/register" method="POST" modelAttribute="employee">
        <div class="form-group">
            <label>Name:</label><form:input path="name" size="30" cssClass="form-control" placeholder="Enter name" />
            <small><form:errors path="name" cssClass="error" /></small>
        </div>
        <div class="form-group">
            <label>Age:</label><form:input path="age" cssClass="form-control" placeholder="Enter age" />
            <small><form:errors path="age" cssClass="error" /></small>
        </div>
        <div class="form-group">
            <label>Salary:</label><form:input path="salary" cssClass="form-control" placeholder="Enter Salary" />
            <small><form:errors path="salary" cssClass="error" /></small>
        </div>
        <div class="form-group">
            <button type="submit" >Submit</button>
        </div>
    </form:form>
</div>
</body>
</html>
