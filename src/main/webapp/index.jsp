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

    <!-- stylesheets css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/bootstrap.min.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/magnific-popup.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/animate.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/font-awesome.min.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/nivo-lightbox.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/nivo_themes/default/default.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/hover-min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/flexslider.css">

    <link rel="stylesheet" href="css/style.css">

    <link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,300,600' rel='stylesheet' type='text/css'>


    <!-- Start of HubSpot Embed Code -->
    <script type="text/javascript" id="hs-script-loader" async defer src="//js.hs-scripts.com/8927045.js"></script>
    <!-- End of HubSpot Embed Code -->
    <style>
        a {
            text-decoration: none; /* Отменяем подчеркивание у ссылки */
        }
    </style>
</head>

<body>
<div>
    <div class="collapse navbar-collapse">
        <ul class="nav navbar-nav navbar-right">
            <h6><a href="${pageContext.request.contextPath}/languageButton?language=ru">ru</a>
                <a>|</a>
                <a href="${pageContext.request.contextPath}/languageButton?language=en">en</a>
                <a>|</a>
                <a href="${pageContext.request.contextPath}/languageButton?language=by">by</a></h6>
            <h1><a href="${pageContext.request.contextPath}/">Financial assistant</a></h1>
        </ul>
    </div>
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
