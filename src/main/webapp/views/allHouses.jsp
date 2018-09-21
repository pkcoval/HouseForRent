<%--
  Created by IntelliJ IDEA.
  User: piotrek
  Date: 31.07.18
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/fragments/header.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1">
    <tr>
        <th>
            <div>
                <form>
                    <input type="button" value="Nazwa " onclick="window.location.href='/house/allNameAsc'"/>
                </form>
            </div>
        </th>
        <th>Adres </th>
        <th>
            <div>
            <form>
                <input type="button" value="Cena " onclick="window.location.href='/house/allPriceAsc'"/>
            </form>
            </div>
        </th>
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

<form:form method="post" >

    <h3>Zaawansowane wyszukiwanie</h3>
    Cena domku mniejsza/wieksza od: <input type="number" name="number"   >
    <select name="wiekszyMniejszy">
        <option value="wiekszy">wiekszy</option>
        <option value="mniejszy">mniejszy</option>
    </select>
    <input type="submit" value="Szukaj"><br>

</form:form>

<form:form method="post"  action="/house/byRating" >

    Ocena domku mniejsza/wieksza od: <input type="number" name="number"   >
    <select name="wiekszyMniejszy">
        <option value="wiekszy">wiekszy</option>
        <option value="mniejszy">mniejszy</option>
    </select>
    <input type="submit" value="Szukaj"><br>

</form:form>

<form:form method="post" action="/house/byName">
    <form>
        Nazwa domku: <input type="text"  name="houseName" >
        <input type="submit" value="Szukaj"><br>
        <%--<input type="button" value="Szukaj " onclick="window.location.href='/byName/${houseName}'"/>--%>
    </form>
</form:form>

</body>
</html>
