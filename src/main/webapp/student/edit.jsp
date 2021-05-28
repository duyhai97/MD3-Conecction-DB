<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TruongDubai
  Date: 5/28/2021
  Time: 6:45 PM
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

<h1>Sửa thông tin hoc sinh</h1>
<h3><a href="/student">Quay lại</a></h3>

<c:if test='${requestScope["message"] != null}'>
    <span class="message">${requestScope["message"]}</span>
</c:if>

<form  method="post">
    <table>
        <tr>
            <td>Tên học sinh:</td>
            <td><input type="text" name="name" id="name" value="${requestScope["student"].getName()}"></td>
        </tr>
        <tr>
            <td>Ngày sinh:</td>
            <td><input type="text" name="dob" id="" value="${requestScope["student"].getDob()}"></td>
        </tr>
        <tr>
            <td>Địa chỉ: </td>
            <td><input type="text" name="address" id="address" value="${requestScope["student"].getAddress()}"></td>
        </tr>
        <tr>
            <td>Lớp học:</td>
            <td>
                <select name="classId" >
                    <c:forEach items="${classedList}" var="c">
                        <option value="${c.getId()}">${c.getName()}</option>
                    </c:forEach>

                </select>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Nhấn đê :v"></td>
        </tr>
    </table>
</form>

</body>
</html>
