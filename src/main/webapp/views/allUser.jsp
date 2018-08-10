<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: piotrek
  Date: 03.08.18
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/fragments/header.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1">
    <tr>
        <th>Imie </th>
        <th>Nazwisko </th>
        <th>Email </th>
        <th>Rezerwacje </th>
    </tr>


    <c:forEach items="${userList}"  var="user">
        <tr>
            <td>${user.firstName} </td>
            <td>${user.lastName} </td>
            <td>${user.email} </td>
            <td>
                <form>
                    <input type="button" value="Rezerwacje " onclick="window.location.href='/user/reservation/${user.id}'"/>
                </form>
            </td>

        </tr>
    </c:forEach>
</table>

</body>
</html>
