<%@ page import="bsu.tp.financial.entity.Currency" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="${cookie['language'].value}"/>
<fmt:setBundle basename="language"/>

<html>
<head>
    <title><fmt:message key="label.signUp"/></title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no"/>
    <%--    <link rel="stylesheet" href="view/assets/css/main.css"/>--%>
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
        <li><a href="${pageContext.request.contextPath}/signIn"><fmt:message key="label.signIn"/></a></li>
        <li class="current"><a href="${pageContext.request.contextPath}/signUp"><fmt:message
                key="label.signUp"/></a></li>

    </ul>

    <form method="post" action="${pageContext.request.contextPath}/signUpButton">
        <section>
            <header>
                <h2><fmt:message key="label.signUp"/></h2>
            </header>
            <div>
                <label>
                    <input type="text" required placeholder="<fmt:message key="label.surname"/>"
                           name="surname">
                </label>
                <label>
                    <input type="text" required placeholder="<fmt:message key="label.name"/>"
                           name="name">
                </label>
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

                <label>
                    <select required name="currency">
                        <option value="" disabled selected><fmt:message key="label.currency" /> <fmt:message key="label.rainyDay"/> </option>
                        <c:set var="currencies" value="<%=Currency.values()%>" />
                        <c:forEach var="currency" items="${currencies}">
                            <option value="${currency}"><fmt:message key="label.${currency}"/></option>
                        </c:forEach>
                    </select>
                </label>

                <button>
                    <fmt:message key="label.signUpButton"/>
                </button>

            </div>
        </section>
    </form>
</div>
</body>
</html>