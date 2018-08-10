<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: piotrek
  Date: 03.08.18
  Time: 12:35
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
        <th>Nazwa domku </th>
        <th>Cena za dzień </th>
        <th>Adres </th>


    </tr>
        <tr>
            <td>${user.houseToRent.name} </td>
            <td>${user.houseToRent.price} </td>
            <td>${user.houseToRent.adress} </td>

        </tr>
</table>

<table border="1">
    <tr>
        <th>Od kiedy </th>
        <th>Do kiedy </th>
        <th>Cena całkowita</th>
        <th>Czy wyporzyczony recznik  </th>
        <th>Czy wyporzyczona posciel </th>
        <th>Nazwa domku </th>
    </tr>
    <c:forEach items="${user.reservationList}"  var="reservation">
        <tr>
            <td>${reservation.startRent} </td>
            <td>${reservation.endRent} </td>
            <td>${reservation.price} </td>
            <td>${reservation.towel} </td>
            <td>${reservation.bedclothes} </td>
            <td>${reservation.houseReservation.name} </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
