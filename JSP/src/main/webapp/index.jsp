<%--<%@page extends="com.mantiso.SimpleServlet" %>--%>
<%--need a func in a base class that we gonna be use--%>
<%--<%@page buffer="8kb" %>--%>
<%--<%@page autoFlush="true" %>--%>
<%--buffer is full runtime throws an exception--%>
<%--Modify the behavior of servlet container--%>
<%--<%@page contentType="text/html; ISO-8859-1" %>--%>
<%--set content type--%>
<%--<%@page errorPage="" %>--%>
<%--specify error page when throws exception can set in web.xml--%>
<%--overwrite that in here--%>
<%--<%@page isErrorPage="true" %>--%>
<%--has intrinsic infos use to display error info--%>
<!DOCTYPE html>
<html>
<head>
    <title>My App</title>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="metro-bootstrap-master/css/metro-bootstrap.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<%@include file="_header.jsp"%>
<section class="main container-fluid">
    <div class="container">
        <h1>Home</h1>

        <div class="row-fluid">
            <div class="col-md-3">Sidebar</div>
            <div class="col-md-9">
                <tabset>
                    <tab heading="Search">
                        <div>
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
