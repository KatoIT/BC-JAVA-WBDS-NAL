<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Setting</title>
</head>
<body>
<h1>Settings</h1>
<form action="/setting" method="post">
    <table>
        <tr>
            <th>Languages</th>
            <td>
                <select name="language" id="language">
                    <c:forEach items="${languages}" var="language">
                        <option value="${language}"
                        <c:if test="${settingEmail.language == language}">
                            selected
                        </c:if>
                        >${language}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <th>Page Size:</th>
            <td>Show
                <select name="pageSize" id="pageSize">
                    <c:forEach items="${pageSizes}" var="pageSize">
                        <option value="${pageSize}"
                                <c:if test="${settingEmail.pageSize == pageSize}">
                                    selected
                                </c:if>
                        >${pageSize}</option>
                    </c:forEach>
                </select>
                emails per page
            </td>
        </tr>
        <tr>
            <th>Spams filter:</th>
            <td>
                <input type="checkbox" name="spamsFilter" id="spamsFilter"
                <c:if test="${settingEmail.spamsFilter}">
                       checked
                </c:if>>
                <lable for="spamsFilter">Enable spams filter</lable>
            </td>
        </tr>
        <tr>
            <th>Signature</th>
            <td>
                <textarea name="signature" id="signature" cols="30" rows="3">${settingEmail.signature}</textarea>
            </td>
        </tr>
        <tr>
            <th></th>
            <td>
                <button type="submit">Update</button>
                <button>Cancel</button>
            </td>
        </tr>
    </table>

</form>
</body>
</html>
