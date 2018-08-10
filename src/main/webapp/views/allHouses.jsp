<%--
  Created by IntelliJ IDEA.
  User: piotrek
  Date: 31.07.18
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/fragments/header.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1">
    <tr>
        <th>Nazwa </th>
        <th>Adres </th>
        <th><div>
            <form>
                <input type="button" value="Cena " onclick="window.location.href='/house/allPriceAsc'"/>
            </form>
        </div>  </th>
        <th>Szczegóły </th>
        <th>Wynajem </th>
    </tr>


    <c:forEach items="${houseList}"  var="house">
        <tr>
            <td>${house.name} </td>
            <td>${house.adress} </td>
            <td>${house.price} </td>
            <td>
                <form>
                    <input type="button" value="Szczegóły " onclick="window.location.href='/house/details/${house.id}'"/>
                </form>
            </td>
            <td>
                <form>
                    <input type="button" value="Wynajmij " onclick="window.location.href='/house/rent/${house.id}'"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
