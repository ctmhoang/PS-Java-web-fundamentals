<%--
  Created by IntelliJ IDEA.
  User: Camer
  Date: 15/9/2020
  Time: 4:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>SignIn</title>
</head>
<body>
<h2>Home</h2>
<a href="/app/home.jsp"><h2>/app/home.jsp</h2></a>

<a href="<c:url value="/app/home.jsp"/>
"><h2><c:url value="/app/home.jsp"/></h2></a>

</body>
</html>
