<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    Добро пожаловать, <sec:authentication property="principal.username"/>! (<a href="/login?logout">выйти</a>)
</p>

<sec:authorize var="grantedToEdit" access="hasAuthority('ADMIN')"></sec:authorize>
<sec:accesscontrollist var="grantedToAdd" domainObject="${dict}" hasPermission="4"></sec:accesscontrollist>


<c:url var="addElemUrl" value="/dict/${dict.id}/0"/>
<c:url var="addUrl" value="/dict/${dict.id}"/>
<p>Справочник:</p>
<div>
    <c:if test="${grantedToEdit}">
        <form:form action="${addUrl}" method="post" modelAttribute="dict">
            <form:hidden path="id"/>
            <form:input path="name"/>
            <button>сохранить</button>
        </form:form>
    </c:if>
    <c:if test="${!grantedToEdit}">
        ${dict.name}
    </c:if>
</div>


<c:if test="${dict.id != 0}">
    <c:if test="${grantedToEdit or grantedToAdd}">
        <a style="color: cornflowerblue" href="${addElemUrl}">Добавить элемент</a>
    </c:if>
    <p>
        Перечень элементов справочника:
    </p>
</c:if>


<c:if test="${not empty elements}">
    <ol>
        <c:forEach var='elem' items='${elements}'>
            <li>
                <c:out value="${elem.name}"></c:out>
            </li>
        </c:forEach>
    </ol>
</c:if>

<p>
    <a href="<c:url value='/dict/'/>">к перечню справочников</a>
</p>
</body>
</html>
