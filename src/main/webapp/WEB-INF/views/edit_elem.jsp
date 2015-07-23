<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


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
<p>
    Добро пожаловать, <sec:authentication property="principal.username" />! (<a href="/login?logout">выйти</a>)
</p>

<c:url var="addElemUrl" value="/dict/${elem.dictId}/${elem.id}"/>
<form:form modelAttribute="elem" method="post" action="${addElemUrl}">
    <form:hidden path="id"/>
    <form:hidden path="dictId"/>
    <form:input path="name"/>

    <button>Сохранить</button>
</form:form>

<p>
    <a href="<c:url value='/dict/${elem.dictId}'/>">к перечню элементов справочника</a>
</p>

</body>
</html>
