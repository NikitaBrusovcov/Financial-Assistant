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
    <title><fmt:message key="label.profile"/></title>
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
                <li><a href="${pageContext.request.contextPath}/"><fmt:message key="label.home"/> </a>
                </li>
                <li><a href="${pageContext.request.contextPath}/adminProfile">${sessionScope.admin.email}</a></li>
                <li><a href="${pageContext.request.contextPath}/signOutButton"><fmt:message key="label.signOut"/></a>
                </li>
            </ul>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li></li>
                <li></li>
                <li><a href="${pageContext.request.contextPath}/users"><fmt:message
                        key="label.users"/></a></li>
                <li><a href="${pageContext.request.contextPath}/admins"><fmt:message
                        key="label.admin"/></a></li>
                <li><a href="${pageContext.request.contextPath}/adminEdit"><fmt:message key="label.edit"/></a></li>
            </ul>
        </div>
    </div>
</div>


<!-- Feature section -->
<section id="feature" class="parallax-section">
    <div class="container">
        <div class="row">

            <div class="col-md-offset-2 col-md-8 col-sm-offset-1 col-sm-10">
                <div class="wow fadeInUp section-title" data-wow-delay="0.6s">
                    <h2>${sessionScope.admin.email}</h2>
                    <h4><fmt:message key="label.hello"/></h4>
                    <h3>Теперь ты предводитель чужого баблишка!</h3>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Copyright section -->
<section id="copyright">
    <div class="container">
        <div class="row">

            <div class="col-md-8 col-sm-8 col-xs-8">
                <p>Copyright © 2020 RFCT TEAM (KREIN, LEBEDEVSKIY, PYSTUNNIK) - <a rel="nofollow" class="designed-by" href="https://github.com/NikitaKrein/Financial-Assistant">Github</a></p>
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
    <title><fmt:message key="label.profile"/></title>
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

    <header>
        <h2>${sessionScope.admin.email}</h2>
        <p><fmt:message key="label.hello"/></p>
    </header>
</div>


</body>
</html>