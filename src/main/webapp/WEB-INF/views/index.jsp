<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sandwich</title>
</head>
<body>
<div>
    <form action="<c:url value="/sandwich/save"/>" method="post">
        <input type="checkbox" name="condiment" value="lettuce" id="lettuce">
        <label for="lettuce">Lettuce</label>
        <br>
        <input type="checkbox" name="condiment" value="tomato" id="tomato">
        <label for="tomato">Tomato</label>
        <br>
        <input type="checkbox" name="condiment" value="mustard" id="mustard">
        <label for="mustard">Mustard</label>
        <br>
        <input type="checkbox" name="condiment" value="sprouts" id="sprouts">
        <label for="sprouts">Sprouts</label>
        <hr>
        <button type="submit">Save</button>
    </form>
</div>

</body>
</html>
