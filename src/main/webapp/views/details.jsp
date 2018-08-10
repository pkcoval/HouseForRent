<%--
  Created by IntelliJ IDEA.
  User: piotrek
  Date: 31.07.18
  Time: 15:17
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


<p> Średnia ocena: ${resultRating} z ${ratingsSize} ocen </p>

<table border="1">
    <tr>
        <td><h3>Komentarze</h3> </td>
    </tr>

    <c:forEach items="${comments}" var="comment">
        <tr>
            <td>${comment.comment} </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
