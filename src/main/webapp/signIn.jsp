<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<fmt:setLocale value="${cookie['language'].value}"/>
<fmt:setBundle basename="language"/>

<html lang="${cookie['language'].value}">
<head>
    <title><fmt:message key="label.signIn"/></title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no"/>
    <%--    <link rel="stylesheet" href="view/assets/css/main.css"/>--%>
    <%--    <style><%@include file="view/assets/css/main.css"%></style>--%>

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

    <nav>
        <ul>
            <li><a href="${pageContext.request.contextPath}/"><fmt:message key="label.home"/> </a></li>
            <li class="current"><a href="${pageContext.request.contextPath}/signIn"><fmt:message
                    key="label.signIn"/></a></li>
            <li><a href="${pageContext.request.contextPath}/signUp"><fmt:message key="label.signUp"/></a></li>

        </ul>
    </nav>

    <form method="post" action="${pageContext.request.contextPath}/signInButton">
        <section>
            <header class="major">
                <h2><fmt:message key="label.signIn"/></h2>
            </header>
            <div>
                <label>
                    <input type="email" name="email" required
                           placeholder="<fmt:message key="label.email"/>">
                </label>
                <label>
                    <input type="password" name="password" required
                           placeholder="<fmt:message key="label.password"/>">
                </label>
                <button>
                    <fmt:message key="label.signInButton"/>
                </button>
            </div>
        </section>
    </form>


</div>
</body>
</html>