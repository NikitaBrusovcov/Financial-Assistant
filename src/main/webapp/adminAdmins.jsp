<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="${cookie['language'].value}"/>
<fmt:setBundle basename="language"/>


<html>
<head>
    <title><fmt:message key="label.admin"/></title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no"/>
    <%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/assets/css/main.css"/>--%>
    <%--    <style><%@include file="view/assets/css/main.css"%></style>--%>

</head>
<body>
<div>

    <h6><a href="${pageContext.request.contextPath}/languageButton?language=ru">ru</a>
        <a>|</a>
        <a href="${pageContext.request.contextPath}/languageButton?language=en">en</a>
        <a>|</a>
        <a href="${pageContext.request.contextPath}/languageButton?language=by">by</a></h6>
    <h1><a href="${pageContext.request.contextPath}/">Financial assistant</a></h1>

    <ul>
        <li><a href="${pageContext.request.contextPath}/"><fmt:message key="label.home"/> </a>
        </li>
        <li><a href="${pageContext.request.contextPath}/adminProfile">${sessionScope.admin.email}</a></li>
        <li><a href="${pageContext.request.contextPath}/signOutButton"><fmt:message key="label.signOut"/></a>
        </li>
    </ul>
    <p></p>
    <ul>
        <li><a href="${pageContext.request.contextPath}/users"><fmt:message
                key="label.users"/></a></li>
        <li><a href="${pageContext.request.contextPath}/admins"><fmt:message
                key="label.admin"/></a></li>
        <li><a href="${pageContext.request.contextPath}/adminEdit"><fmt:message key="label.edit"/></a></li>
    </ul>

    <table>
        <c:forEach var="admin" items="${requestScope.admins}">
            <tr>
                <td>${admin.email}</td>
            </tr>
        </c:forEach>
    </table>
    <p></p>
    <p></p>
    <form action="${pageContext.request.contextPath}/createAdminButton">
        <label>
            <input type="email" required placeholder="<fmt:message key="label.email"/>"
                   name="email">
        </label>
        <label>
            <input type="password" required placeholder="<fmt:message key="label.password"/>"
                   name="password" minlength="6">
        </label>
        <label>
            <input type="password" required
                   placeholder="<fmt:message key="label.repeatPassword"/>" name="repeatPassword"
                   minlength="6">
        </label>
        <button><fmt:message key="label.add"/></button>
    </form>

</div>


</body>
</html>