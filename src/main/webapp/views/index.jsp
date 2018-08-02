<%--
  Created by IntelliJ IDEA.
  User: piotrek
  Date: 31.07.18
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form>
    <input type="button" value="Dodaj użytkownika" onclick="window.location.href='/user/add'"/>
</form>

<form>
    <input type="button" value="Wszystkie domki" onclick="window.location.href='/house/all'"/>
</form>

<form>
    <input type="button" value="Dodaj komentarz do domku" onclick="window.location.href='/comment/add'"/>
</form>

<form>
    <input type="button" value="Dodaj ocene domku" onclick="window.location.href='/rating/add'"/>
</form>


</body>
</html>
