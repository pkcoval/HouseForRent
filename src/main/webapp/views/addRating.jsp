<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: piotrek
  Date: 31.07.18
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" modelAttribute="rating">
    <div>Ocena <form:input path="rating" />          <form:errors path="rating" cssStyle="color: #dc0001"  /> </div>
    <div>Wybierz domek <form:select itemLabel="name" itemValue="id" path="house.id" items="${allHouse}"/></div>

    <input type="submit" value="Save">
</form:form>

</body>
</html>
