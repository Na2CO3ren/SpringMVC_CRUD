<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${pageContext.request.contextPath }/robin/testConverter" method="post">
    <input type="text" name="employee">
    <input type="submit" value="submit">
</form>


<form:form action="${pageContext.request.contextPath }/robin/addEmployee" method="POST"
           modelAttribute="employee">

    <c:if test="${employee.id == null}">
        <%--国际化显示--%>
        <fmt:message key="i18n.lastName"/> : <form:input path="lastName"/>
        <%--错误显示--%>
        <form:errors path="lastName"/>
    </c:if>

    <c:if test="${employee.id != null}">
        <input type="hidden" name="id" value="${employee.id}">
    </c:if>

    <br>
    <fmt:message key="i18n.age"/> : <input type="text" name="age" value="${employee.age}">

    <br>
    <fmt:message key="i18n.department"/> : <form:select path="department.id" items="${departments }"
                                                        itemLabel="depName" itemValue="id"/>
    <br>
    <%--    birth: <input type="text" name="birth">--%>
    <fmt:message key="i18n.birth"/> ： <form:input path="birth"/>
    <form:errors path="birth"/>
    <br>
    <fmt:message key="i18n.salary"/> : <input type="text" name="salary">
    <br>
    <input type="submit" value="submit">
</form:form>

</body>
</html>
