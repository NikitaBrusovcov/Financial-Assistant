<%@ page import="bsu.tp.financial.entity.Currency" %>
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

    <title><fmt:message key="label.forgotPassword"/></title>
    <meta charset="utf-8"/>

    <style>
        a {
            text-decoration: none; /* Отменяем подчеркивание у ссылки */
        }
    </style>


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
<body>

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
                <li><a href="${pageContext.request.contextPath}/signIn"><fmt:message key="label.signIn"/></a></li>
                <li><a href="${pageContext.request.contextPath}/signUp"><fmt:message key="label.signUp"/></a></li>
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
                    <h2><fmt:message key="label.forgotPassword"/></h2>
                </div>
                <form id="contact-form" method="post" action="${pageContext.request.contextPath}/forgotPasswordButton">
                    <input type="email" name="email" class="form-control" required
                           placeholder="<fmt:message key="label.email"/>">

                    <input type="submit" class="form-control submit" value=
                    <fmt:message key="label.sendToMail"/>>
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