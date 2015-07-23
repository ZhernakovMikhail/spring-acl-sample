<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Misha
  Date: 22.07.2015
  Time: 1:50
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

<p>Перечень доступных справочников:</p>
<c:if test="${not empty dicts}">
    <ol>
        <c:forEach var='dict' items='${dicts}'>
            <li>
                <c:url var="viewUrl" value="/dict/${dict.id}"/>
                <a href="${viewUrl}">${dict.name}</a>
            </li>
        </c:forEach>
    </ol>
</c:if>
<c:if test="${empty dicts}">
    <p>Администратор должен добавить справочник, для того чтобы пользователь смог создавать в нем элементы</p>
</c:if>


<sec:authorize access="hasAuthority('ADMIN')">
    <c:url var="addElemUrl" value="/dict/0"/>
    <a style="color: green" href="${addElemUrl}">Добавить справочник</a>
</sec:authorize>


</body>
</html>
