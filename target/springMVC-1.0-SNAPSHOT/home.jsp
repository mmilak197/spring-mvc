<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>First JSP</title></head>
<body>

<p>Home ${nick}</p>

<div style="text-align: center">

    <a href="login">Login</a>
    <a href="register">Register</a>

</div>

<c:forEach var="product" items="${products}">
    <c:if test="${product.category == 'koszulki'}">
        <li>${product.name}</li>
    </c:if>
</c:forEach>

</body>
</html>