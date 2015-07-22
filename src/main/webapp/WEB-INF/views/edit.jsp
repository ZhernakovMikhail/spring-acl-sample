<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>


<%--
  Created by IntelliJ IDEA.
  User: Misha
  Date: 22.07.2015
  Time: 2:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<c:url var="addUrl" value="/dict/1/0"/>
<form:form modelAttribute="elem" method="post" action="${addUrl}">
    <form:hidden path="id"/>
    <form:hidden path="dictId"/>

    <form:input path="name"/>

    <button>Сохранить</button>
</form:form>

</body>
</html>
