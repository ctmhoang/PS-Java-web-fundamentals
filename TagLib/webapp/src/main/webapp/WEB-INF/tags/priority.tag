<%@ tag body-content="scriptless" %>
<%--contains html el tags but not js--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="user" required="true" type="com.mantiso.User" %>
<%@ attribute name="normalPriority" fragment="true" %>
<%--mark as html fragment--%>
<%@ attribute name="highPriority" fragment="true" %>
<%@ variable name-given="description" %>
<%--set var to use other method--%>
<%@ variable name-given="priority" %>

<ul>
    <c:forEach items="${user.todos}" var="todo">
        <c:set var="description" value="${todo.description}"/>
        <c:set var="priority" value="${todo.priority}"/>
<%--        set the var we declared--%>
        <c:if test="${todo.priority == 1}">
            <jsp:invoke fragment="normalPriority"/>
<%--            call the fragment--%>
        </c:if>
        <c:if test="${todo.priority > 1}">
            <jsp:invoke fragment="highPriority"/>
        </c:if>
    </c:forEach>
</ul>
