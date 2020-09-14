<%--<jsp:useBean id="user" scope="request" type="javax.xml.stream.util.StreamReaderDelegate"/>--%>
<%--can declare or not declare--%>
<%@ page import="java.util.Calendar" %>
<%@ page import="com.mantiso.User" %>
<!DOCTYPE html>
<html>
<head>
<%--    <title><%= application.getInitParameter("ProductName") %>--%>
    <title>${initParam.ProductName}
<%--        get the scope of whole application--%>
    </title>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="metro-bootstrap-master/css/metro-bootstrap.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="app.css">
</head>
<body>
<%@include file="_header.jsp" %>
<section class="main container-fluid">
    <%
        Calendar calendar = Calendar.getInstance();
    %>
    <div class="container">
        <h1>Home</h1>
        <div class="row-fluid">
            <div class="col-md-3">
                <%= calendar.getTime().toString() %>
            </div>
            <div class="col-md-9">
                <ul class="nav nav-tabs">
                    <li><a href="#home" data-toggle="tab">${app.tabNames[0]}</a></li>
                    <li><a href="#other" data-toggle="tab">${app.tabNames[1]}</a></li>
                    <li><a href="#messages" data-toggle="tab">${app.tabNames[2]}</a></li>
                    <li><a href="#settings" data-toggle="tab">${app.tabNames[3]}</a></li>
                </ul>

                <div class="tab-content">
                    <div class="tab-pane active" id="home">
                        <div class="${app["formCssClass"]["name"]}">
                            <h2>Welcome ${ user.name }</h2>
                            <form action="home" method="post">
                                <p>
                                    Name: <input type="text" name="name"/>
                                </p>

                                <p>
                                    <input type="submit" value="Enter name">
                                </p>
                            </form>
                        </div>
                    </div>
                    <div class="tab-pane" id="other">
                        Yet More Static content
                    </div>
                </div>

                <tabset>
                    <tab heading="Search">
                        <div class="${app["formCssClass"].name}">
<%--                            actually it is a name after set and get method not field name--%>
                            <h2>Welcome ${user.name}</h2>
<%--                            do not need to declare cuz it will search through all scope within servlet context from small to large--%>
                            <form action="home" method="post">
                                <p>
                                    Name: <input type="text" name="name"/>
                                </p>

                                <p>
                                    <input type="submit" value="Enter name">
                                </p>
                            </form>
                        </div>
                    </tab>
                    <tab heading="Next">
                        Yet More Static content
                    </tab>
                </tabset>

            </div>
        </div>
    </div>
</section>
<script src="bootstrap/js/bootstrap.js"></script>
</body>
</html>
