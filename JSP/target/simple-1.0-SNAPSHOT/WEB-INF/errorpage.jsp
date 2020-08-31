<%--
  Created by IntelliJ IDEA.
  User: Camer
  Date: 30/8/2020
  Time: 4:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Error Page</title>
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/metro-bootstrap-master/css/metro-bootstrap.css">
</head>
<body>
<h2>Error page</h2>
<%= exception.getMessage()%>
</body>
</html>
