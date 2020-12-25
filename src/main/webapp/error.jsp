<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="${cookie['language'].value}"/>
<fmt:setBundle basename="language"/>
<html>
<head>

    <!-- Start of HubSpot Embed Code -->
    <script type="text/javascript" id="hs-script-loader" async defer src="//js.hs-scripts.com/8927045.js"></script>
    <!-- End of HubSpot Embed Code -->
    <title><fmt:message key="label.financialAssistant"/></title>
    <meta charset="utf-8"/>

    <!--

    Tooplate 2083 Steak House

    https://www.tooplate.com/view/2083-steak-house

    -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords" content="">
    <meta name="description" content="">

    <!-- stylesheets css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/bootstrap.min.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/magnific-popup.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/animate.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/font-awesome.min.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/nivo-lightbox.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/nivo_themes/default/default.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/hover-min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/flexslider.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/style.css">

    <link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,300,600' rel='stylesheet' type='text/css'>

</head>
<body id="top" data-spy="scroll" data-target=".navbar-collapse" data-offset="50">

<!-- Navigation section -->
<div class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container">

        <div class="navbar-header">
            <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon icon-bar"></span>
                <span class="icon icon-bar"></span>
                <span class="icon icon-bar"></span>
            </button>
            <a href="${pageContext.request.contextPath}/languageButton?language=ru" class="navbar-brand">ru</a>
            <a class="navbar-brand">|</a>
            <a href="${pageContext.request.contextPath}/languageButton?language=en" class="navbar-brand">en</a>
            <a class="navbar-brand">|</a>
            <a href="${pageContext.request.contextPath}/languageButton?language=by" class="navbar-brand">by</a>
            <p></p>
            <a href="${pageContext.request.contextPath}/" class="navbar-brand">Financial assistant</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${pageContext.request.contextPath}/"><fmt:message key="label.home"/> </a></li>
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

    </div>
</div>

<section id="contact" class="parallax-section">
    <div class="overlay"></div>
    <div class="container">
        <div class="row">
            <div class="col-md-offset-2 col-md-8 col-sm-offset-1 col-sm-10">
                <div class="contact-form wow fadeInUp" data-wow-delay="0.7s">
                    <h2><fmt:message key="label.error"/></h2>
                </div>
                <h1><fmt:message key="label.somethingWentWrong"/></h1>
                <form id="contact-form" method="post" action="${pageContext.request.contextPath}/">
                    <input type="submit" class="form-control submit" value=<fmt:message key="label.homePage"/>>
                </form>
            </div>
        </div>

    </div>
</section>


<!-- Copyright section -->
<section id="copyright">
    <div class="container">
        <div class="row">

            <div class="col-md-8 col-sm-8 col-xs-8">
                <p>Copyright © 2020 RFCT TEAM (KREIN, LEBEDEVSKIY, PYSTUNNIK) - <a rel="nofollow" class="designed-by"
                                                                                   href="https://github.com/NikitaKrein/Financial-Assistant">Github</a>
                </p>
            </div>
        </div>
    </div>
</section>
</body>
</html>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<fmt:setLocale value="${cookie['language'].value}"/>
<fmt:setBundle basename="language"/>


<html>
<head>
    <title><fmt:message key="label.error"/></title>
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
    <h1><fmt:message key="label.somethingWentWrong"/></h1>
    <button>
        <a href="${pageContext.request.contextPath}/"><fmt:message key="label.homePage"/></a>
    </button>
</div>
</body>
</html>