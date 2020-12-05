<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<fmt:setLocale value="${cookie['language'].value}"/>
<fmt:setBundle basename="language"/>


<html>
<head>
    <title><fmt:message key="label.edit"/></title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no"/>
    <%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/assets/css/main.css"/>--%>
    <%--    <style><%@include file="view/assets/css/main.css"%></style>--%>
    <style>
        a {
            text-decoration: none; /* Отменяем подчеркивание у ссылки */
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

    <form method="post" action="${pageContext.request.contextPath}/editProfileButton"
          accept-charset="UTF-8">
        <section>
            <header class="major">
                <h2><fmt:message key="label.edit"/></h2>
            </header>
            <div>
                <label>
                    <input type="password" placeholder="<fmt:message key="label.oldPassword"/>" name="oldPassword" minlength="6">
                </label>
                <label>
                    <input type="password" placeholder="<fmt:message key="label.newPassword"/>" name="password" minlength="6">
                </label>
                <label>
                    <input type="password" placeholder="<fmt:message key="label.repeatPassword"/>"
                           name="repeatPassword">
                </label>

                <button>
                    <fmt:message key="label.edit"/>
                </button>
            </div>
        </section>
    </form>
    <form action="${pageContext.request.contextPath}/deleteProfileButton">
        <button>
            <fmt:message key="label.delete"/>
        </button>
    </form>
</div>

</body>
<!-- шобы стрелок не было -->
<style>
    input[type='number'] {
        -moz-appearance: textfield;
    }

    input::-webkit-outer-spin-button,
    input::-webkit-inner-spin-button {
        -webkit-appearance: none;
    }
</style>
</html>