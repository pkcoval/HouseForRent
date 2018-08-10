<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: piotrek
  Date: 31.07.18
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/fragments/header.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" modelAttribute="user">
    <div>Imię<form:input path="firstName" />          <form:errors path="firstName" cssStyle="color: #dc0001"  /> </div>
    <div>Nazwisko<form:input path="lastName" />       <form:errors path="lastName" cssStyle="color: #dc0001"  /></div>
    <div>Email<form:input path="email" />             <form:errors path="email" cssStyle="color: #dc0001"  /></div>
    <input type="submit" value="Save">
</form:form>

</body>
</html>
