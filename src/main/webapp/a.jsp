<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: zhao_temporary
  Date: 2022/3/20
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
abc:${requestScope.abc}<br/>


<c:set scope="request" var="abc" value="abcValue"/> <br/>

<c:if test="${12 == 12}">
    <h1> 12 等于 12</h1>
</c:if>

<%
    request.setAttribute("height", 178);
%>

<c:choose>
    <c:when test="${requestScope.height > 190} ">
        <h2>小巨人</h2>
    </c:when>
    <c:when test="${requestScope.height > 180}">
        <h2>很高</h2>
    </c:when>
    <c:otherwise>
        <h2>还可以</h2>
    </c:otherwise>
</c:choose>
<hr>

<%
    request.setAttribute("arr", new String[]{"11111111", "22222222", "33333333", "4444444444"});
%>
<c:forEach items="${requestScope.arr}" var="object">
    ${object}<br/>
</c:forEach>

<%
    Map<String,Object> map = new HashMap<>();
    map.put("key1","value1");
    map.put("key2","value2");
    map.put("key3","value3");
    map.put("key4","value4");
    map.put("key5","value5");
    request.setAttribute("map",map);
%>

<c:forEach items="${requestScope.map}" var="entry">
    ${entry.key}<br>
    ${entry.value}<br>
</c:forEach>
</body>
</html>
