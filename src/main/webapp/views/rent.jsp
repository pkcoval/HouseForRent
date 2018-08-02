<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: piotrek
  Date: 31.07.18
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>




<form:form method="post" modelAttribute="houseToRent">


    <p>Wynajmij domek o nazwie ${houseToRent.name}</p>
    <p>Cena domku: ${houseToRent.price} zł</p>
    <div>Imię<form:input path="name" />
    <div>Czy chcesz dodatkowo ręcznik? Dopłacisz 10zł <form:checkbox path="towel" title="Czy chcesz ręcznik?" value="false" /></div>
    <div>Czy chcesz dodatkowo pościel? Dopłacisz 20zł <form:checkbox path="bedclothes" title="Czy chcesz pościel?" value="false" /></div>
    <div>Wybierz użytkownika <form:select itemLabel="firstName" itemValue="id"  path="userList" items="${allUsers}"/></div>

    <input type="submit" value="Save">
</form:form>

</body>
</html>
