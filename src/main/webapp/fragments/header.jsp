<%--
  Created by IntelliJ IDEA.
  User: piotrek
  Date: 03.08.18
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
    .forDiv {

        width: 19%;
        display: inline-block;

    }
</style>
<head>
    <title>Title</title>
</head>
<body>

<div>
    <a class="forDiv">
        <form>
            <input type="button" value="Dodaj użytkownika" onclick="window.location.href='/user/add'"/>
        </form>
    <a/>
            <a class="forDiv">
        <form>
            <input type="button" value="Wszystkie domki" onclick="window.location.href='/house/all'"/>
        </form>
            <a/>

                <a class="forDiv">
        <form>
            <input type="button" value="Dodaj komentarz do domku" onclick="window.location.href='/comment/add'"/>
        </form>
                <a/>

                <a class="forDiv">
        <form>
            <input type="button" value="Dodaj ocene domku" onclick="window.location.href='/rating/add'"/>
        </form>
                <a/>


                    <a class="forDiv">
                    <form>
                        <input type="button" value="Użytkownicy" onclick="window.location.href='/user/all'"/>
                    </form>
                    <a/>
</div>

</body>
</html>
