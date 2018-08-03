<%--
  Created by IntelliJ IDEA.
  User: piotrek
  Date: 02.08.18
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>Domek w tych terminach jest już wynajęty:</h3>

<table border="1">
    <tr>
        <td>Reserwacja od </td>
        <td>Rezerwacja do </td>

    </tr>
    <c:forEach items="${reservationList}" var="reservation">
        <tr>
            <td>${reservation.startRent} </td>
            <td>${reservation.endRent} </td>

        </tr>
    </c:forEach>
</table>

</body>
</html>
