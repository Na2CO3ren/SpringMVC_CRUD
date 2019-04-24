<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form action="${pageContext.request.contextPath }/robin/addEmployee" method="post" modelAttribute="employee">
    <c:if test="${employee.id == null}">
        lastName: <input type="text" name="lastName" value="${employee.lastName}"/>
    </c:if>

    <c:if test="${employee.id != null}">
        <input type="hidden" name="id" value="${employee.id}">
    </c:if>

    <br>
    age: <input type="text" name="age" value="${employee.age}"/>
    <br>
    department: <form:select path="department.id" items="${departments }" itemLabel="depName" itemValue="id"/>
    <br>
    <input type="submit" value="submit">
</form:form>

</body>
</html>
