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

<c:url var="addUrl" value="/dict/1/0"/>

<c:if test="${not empty elements}">
    <ol>
        <c:forEach var='elem' items='${elements}'>
            <li>
                <c:out value="${elem.name}"></c:out>
            </li>
        </c:forEach>
    </ol>
</c:if>

<sec:authorize
        access="hasAuthority('ADMIN') or hasPermission(#dict, 'CREATE') or hasPermission(#dict, 'ADMINISTRATION')">
    <a href="${addUrl}">добавить</a>
</sec:authorize>

</body>
</html>
