<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TruongDubai
  Date: 5/28/2021
  Time: 7:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .message{
            color: darkmagenta;
        }
    </style>
</head>
<body>
<h1>Xóa học viên</h1>
<h3><a href="/student">Quay lại </a></h3>

<h4>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</h4>

<form action="" method="post">
    <h3>Bạn chắc chắn muốn xóa</h3>
    <fieldset>
        <table>
            <tr>
                <td>Tên học viên:</td>
                <td>${requestScope["student"].getName()}</td>
            </tr>
            <tr>
                <td>Ngày sinh</td>
                <td>${requestScope["student"].getDob()}</td>
            </tr>

            <tr>
                <td>Địa chỉ</td>
                <td>${requestScope["student"].getAddress()}</td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Xóa"></td>
            </tr>
        </table>
    </fieldset>
</form>

</body>
</html>
