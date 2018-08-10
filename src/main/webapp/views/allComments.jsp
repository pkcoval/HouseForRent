<%--
  Created by IntelliJ IDEA.
  User: piotrek
  Date: 31.07.18
  Time: 14:23
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

    <c:forEach items="${comments}" var="comment">
        <tr>
            <td>${comment.comment} </td>

        </tr>
    </c:forEach>
</table>

</body>
</html>
