<%--
  Created by IntelliJ IDEA.
  User: piotrek
  Date: 31.07.18
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1">
    <tr>
        <td>Nazwa </td>
        <td>Adres </td>
        <td><div><a href="/house/allPriceAsc">Cena </a></div>  </td>
        <td>Szczegóły </td>
        <td>Wynajem </td>
    </tr>
    <c:forEach items="${houseList}"  var="house">
        <tr>
            <td>${house.name} </td>
            <td>${house.adress} </td>
            <td>${house.price} </td>
            <td> <div><a href="/house/details/${house.id}">Szczegóły </a></div>   </td>
            <td> <div><a href="/house/rent/${house.id}">Wynajmij </a></div> </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
