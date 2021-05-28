<%--
  Created by IntelliJ IDEA.
  User: TruongDubai
  Date: 5/28/2021
  Time: 4:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách học sinh</title>
    <style>
        table {
            text-align: center;
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            text-align: left;
            padding: 8px;
        }
        tr:nth-child(even){background-color: #f2f2f2}
        th {
            background-color: #4CAF50;
            color: white;
        }
        button{
            border-radius: 8px;
            background: aqua;
        }
        body{
            text-align: center;
        }
    </style>
</head>
<body>
<h2>
    <a href="/student?action=create">Thêm học sinh mới</a>
</h2>

<table>
    <tr>
        <th>ID học sinh</th>
        <th>Tên học sinh</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <td>Tên lớp</td>
        <td>Mô tả</td>
        <td></td>
        <td></td>


    </tr>
    <c:forEach items='${requestScope["studentList"]}' var="s">
        <tr>
            <td>${s.getId()}</td>
            <td><a href="/student?action=view&id=${s.getId()}">${s.getName()}</a></td>
            <td>${s.getDob()}</td>
            <td>${s.getAddress()}</td>
            <td>${s.getClassed().getName()}</td>
            <td>${s.getClassed().getDescribe()}</td>
            <td><a href="/student?action=edit&id=${s.getId()}">Chỉnh sửa</a></td>
            <td><a href="/student?action=delete&id=${s.getId()}">Xóa</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
