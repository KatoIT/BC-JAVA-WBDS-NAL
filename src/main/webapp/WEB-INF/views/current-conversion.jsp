<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 2/16/2022
  Time: 10:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Current Conversion</title>
</head>
<body>
<div>
    <form action="/display" method="get">
        <lable>Tỉ giá: 23 000</lable>
        <hr>
        <lable>USD</lable>
        <input type="number" name="USD" id="USD" value="0">
        <button type="submit">Convert</button>
    </form>
</div>
</body>
</html>
