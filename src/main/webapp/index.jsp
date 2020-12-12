<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="${cookie['language'].value}"/>
<fmt:setBundle basename="language"/>


<html>
<head>
    <title><fmt:message key="label.financialAssistant"/></title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no"/>
</head>

<body>
<div>
    <h6><a href="${pageContext.request.contextPath}/languageButton?language=ru">ru</a>
        <a>|</a>
        <a href="${pageContext.request.contextPath}/languageButton?language=en">en</a></h6>
    <h1><a href="${pageContext.request.contextPath}/">Русский Текст</a></h1>

    <ul>
        <li class="current"><a href="${pageContext.request.contextPath}/"><fmt:message key="label.home"/> </a>
        </li>
        </li>
        <c:choose>
            <c:when test="${not empty sessionScope.user}">
                <li><a href="${pageContext.request.contextPath}/profile">${sessionScope.user.name}</a></li>
                <li><a href="${pageContext.request.contextPath}/signOutButton"><fmt:message
                        key="label.signOut"/></a></li>
            </c:when>
            <c:when test="${not empty sessionScope.admin}">
                <li><a href="${pageContext.request.contextPath}/adminProfile">${sessionScope.admin.email}</a>
                </li>
                <li><a href="${pageContext.request.contextPath}/signOutButton"><fmt:message
                        key="label.signOut"/></a></li>
            </c:when>
            <c:otherwise>
                <li><a href="${pageContext.request.contextPath}/signIn"><fmt:message key="label.signIn"/></a>
                </li>
                <li><a href="${pageContext.request.contextPath}/signUp"><fmt:message key="label.signUp"/></a>
                </li>
            </c:otherwise>
        </c:choose>
    </ul>
</div>
</body>
</html>