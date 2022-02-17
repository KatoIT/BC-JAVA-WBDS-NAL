<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<div>
    <form action="<c:url value="/calculator"/>" method="post">
        <div>
            <input type="number" name="stn" id="stn" placeholder="First number..." value="${stn}">
            <input type="number" name="sth" id="sth" placeholder="Second number..." value="${sth}">
        </div>
        <hr>
        <button type="submit" name="cal" value="1">Add(+)</button>
        <button type="submit" name="cal" value="2">Sub(-)</button>
        <button type="submit" name="cal" value="3">Mul(x)</button>
        <button type="submit" name="cal" value="4">Div(/)</button>
    </form>
    <c:if test="${result != null}">
        <h2>Result: ${result}</h2>
    </c:if>
</div>
</body>
</html>
