<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employee list</title>
</head>
<body>
<h2>Hello 111</h2>

<c:if test="${empty requestScope.employees }">
    没有任何员工
</c:if>

<c:if test="${!empty requestScope.employees }">
    <table border="1">
        <tr>
            <th align="center">ID</th>
            <th align="center">lastName</th>
            <th align="center">age</th>
            <th align="center">department</th>
            <th align="center">delete</th>
            <th align="center">edit</th>
        </tr>

        <c:forEach items="${requestScope.employees }" var="employee">
            <tr>
                <td align="center">${employee.id }</td>
                <td align="center">${employee.lastName }</td>
                <td align="center">${employee.age }</td>
                <td align="center">${employee.department.depName }</td>
                <td><a href="deleteEmployee/${employee.id}">delete</a></td>
                <td><a href="editEmployee/${employee.id }">edit</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<br><br>
<a href="showInput">Add Employee</a>
<br>
<a href="showI18n?locale=zh_CN">中文</a>
<br>
<a href="showI18n?locale=en_US">英文</a>

</body>
</html>
