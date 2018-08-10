<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: piotrek
  Date: 31.07.18
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/fragments/header.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" modelAttribute="comment">
    <div>Dodaj komentarz <form:textarea path="comment" />   <form:errors path="comment" cssStyle="color: #dc0001"  /> </div>
    <div>Wybierz domek <form:select itemLabel="name" itemValue="id" path="houses.id" items="${allHouse}"/></div>

    <input type="submit" value="Save">
</form:form>

</body>
</html>
