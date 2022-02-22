<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculator</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            $("#btnAdd").click(function () {
                let a = parseFloat($("#stn").val());
                let b = parseFloat($("#sth").val());
                $("#demo").text("Result: " + (a + b));
                $("#operator").text("+");
            });
            $("#btnSub").click(function () {
                let a = parseFloat($("#stn").val());
                let b = parseFloat($("#sth").val());
                $("#demo").text("Result: " + (a - b));
                $("#operator").text("-");
            });
            $("#btnMul").click(function () {
                let a = parseFloat($("#stn").val());
                let b = parseFloat($("#sth").val());
                $("#demo").text("Result: " + (a * b));
                $("#operator").text("x");
            });
            $("#btnDiv").click(function () {
                let a = parseFloat($("#stn").val());
                let b = parseFloat($("#sth").val());
                $("#operator").text("/");
                if (b === 0) {
                    $("#demo").text("Mẫu số phải khác 0");
                }else {
                    $("#demo").text("Result: " + (a / b));
                }
            });
        });

    </script>
</head>
<body>
<h1>Calculator</h1>
<div>
    <div>
        <input type="number" name="stn" id="stn" placeholder="First number..." value="0">
        <p id="operator">Operator</p>
        <input type="number" name="sth" id="sth" placeholder="Second number..." value="0">
    </div>
    <hr>
    <button id="btnAdd">Add(+)</button>
    <button id="btnSub">Sub(-)</button>
    <button id="btnMul">Mul(*)</button>
    <button id="btnDiv">Div(/)</button>
    <h2 id="demo"></h2>
</div>

</body>
</html>
