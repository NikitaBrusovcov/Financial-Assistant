<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<fmt:setLocale value="${cookie['language'].value}"/>
<fmt:setBundle basename="language"/>


<html>
<head>
    <title><fmt:message key="label.personalInfo"/></title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no"/>
    <%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/assets/css/main.css"/>--%>
    <%--    <style><%@include file="view/assets/css/main.css"%></style>--%>
    <style>
        a {
            text-decoration: none; /* Отменяем подчеркивание у ссылки */
        }
    </style>

    <!-- Start of HubSpot Embed Code -->
    <script type="text/javascript" id="hs-script-loader" async defer src="//js.hs-scripts.com/8927045.js"></script>
    <!-- End of HubSpot Embed Code -->
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
        <li><a href="${pageContext.request.contextPath}/"><fmt:message key="label.personalInfo"/> </a>
        </li>
        <li class="current"><a href="${pageContext.request.contextPath}/profile">${sessionScope.user.name}</a></li>
        <li><a href="${pageContext.request.contextPath}/signOutButton"><fmt:message key="label.signOut"/></a></li>

    </ul>
    <p></p>
    <ul>
        <li><a href="${pageContext.request.contextPath}/profile/personalInfo"><fmt:message
                key="label.personalInfo"/> </a></li>
        <li><a href="${pageContext.request.contextPath}/profile/bankAccounts"><fmt:message
                key="label.bankAccounts"/></a></li>
        <li><a href="${pageContext.request.contextPath}/profile/rainyDay"><fmt:message key="label.rainyDay"/></a>
        </li>
        <li><a href="${pageContext.request.contextPath}/profile/unitBankAccounts"><fmt:message key="label.unit"/> <fmt:message key="label.bankAccount"/> </a></li>
        <li><a href="${pageContext.request.contextPath}/profile/edit"><fmt:message key="label.edit"/></a></li>
    </ul>


    <header>
        <h2>${sessionScope.user.name} ${sessionScope.user.surname}</h2>
    </header>

    <header>
        <h2>${sessionScope.user.email}</h2>
    </header>

    <header>
        <h2><fmt:message key="label.bankAccounts"/>: ${sessionScope.user.bankAccountList.size()}</h2>
    </header>

</div>

</body>
</html>