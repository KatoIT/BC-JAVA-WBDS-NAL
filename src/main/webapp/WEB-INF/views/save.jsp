<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Save Sandwich</title>
</head>
<body>
<h2>Condiment in Sandwich</h2>
    <c:forEach items="${condiment}" var="item">
        <h3>${item}</h3>
    </c:forEach>
</body>
</html>
