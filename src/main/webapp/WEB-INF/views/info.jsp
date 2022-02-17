<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Info</title>
    <style>
        .button {
            background-color: #04AA6D;
            color: white;
        }
    </style>
</head>
<body>
<h2>Setting</h2>
<h3>Language: ${settingEmail.language}</h3>
<h3>Font Size: ${settingEmail.pageSize}</h3>
<h3>Spams Filter: ${settingEmail.spamsFilter}</h3>
<h3>Signature: ${settingEmail.signature}</h3>
<a href="/setting/edit" class="button">Sửa</a>
</body>
</html>
