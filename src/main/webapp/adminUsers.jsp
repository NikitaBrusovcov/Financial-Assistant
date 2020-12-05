<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="${cookie['language'].value}"/>
<fmt:setBundle basename="language"/>


<html>
<head>
    <title><fmt:message key="label.users"/></title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no"/>
    <%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/assets/css/main.css"/>--%>
    <%--    <style><%@include file="view/assets/css/main.css"%></style>--%>
    <style>
        .read-more-state,
        .read-more-state1 {
            display: none;
        }

        .read-more-target,
        .read-more-target1 {
            display: none;
            max-height: 0;
            font-size: 0;
            transition: .25s ease;
        }

        .read-more-state:checked ~ .read-more-wrap .read-more-target {
            display: block;
            font-size: inherit;
            max-height: 999em;
        }

        .read-more-state1:checked ~ .read-more-wrap1 .read-more-target1 {
            display: block;
            font-size: inherit;
            max-height: 999em;
        }

        .read-more-trigger,
        .read-more-trigger1 {
            cursor: pointer;
            display: inline-block;
            padding: 0 .5em;
            color: #666;
            font-size: .9em;
            line-height: 2;
            border-radius: .25em;

        }
    </style>

</head>
<body>
<div>

    <h6><a href="${pageContext.request.contextPath}/languageButton?language=ru">ru</a>
        <a>|</a>
        <a href="${pageContext.request.contextPath}/languageButton?language=en">en</a></h6>
    <h1><a href="${pageContext.request.contextPath}/">Financial assistant</a></h1>

    <ul>
        <li><a href="${pageContext.request.contextPath}/"><fmt:message key="label.home"/> </a>
        </li>
        <li><a href="${pageContext.request.contextPath}/admin/profile">${sessionScope.admin.email}</a></li>
        <li><a href="${pageContext.request.contextPath}/signOutButton"><fmt:message key="label.signOut"/></a>
        </li>
    </ul>
    <p></p>
    <ul>
        <li><a href="${pageContext.request.contextPath}/users"><fmt:message
                key="label.users"/></a></li>
        <li><a href="${pageContext.request.contextPath}/admin/admins"><fmt:message
                key="label.admin"/></a></li>
        <li><a href="${pageContext.request.contextPath}/admin/edit"><fmt:message key="label.edit"/></a></li>
    </ul>

    <table>
        <c:forEach var="user" items="${requestScope.users}">
            <tr>
                <td>${user.name}</td>
                <td>${user.surname}</td>
                <td>${user.email}</td>
                <td><button name="#"><fmt:message key="label.delete"/> <fmt:message key="label.profile"/></button></td>
                <td><button name="#"><fmt:message key="label.profile"/></button></td>
            </tr>
        </c:forEach>
    </table>
</div>


</body>
</html>