<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<fmt:setLocale value="${cookie['language'].value}"/>
<fmt:setBundle basename="language"/>


<html>
<head>
    <title><fmt:message key="label.unit"/> <fmt:message key="label.bankAccount"/></title>
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
        <li><a href="${pageContext.request.contextPath}/"><fmt:message key="label.rainyDay"/> </a>
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

    <form method="post" action="${pageContext.request.contextPath}/unitBankAccountsButton">
        <label>
            <input type="email" name="accountMail" placeholder="<fmt:message key="label.email"/>" required>
        </label>
        <label>
            <select required name="bankAccount">
                <option value="" disabled selected><fmt:message key="label.bankAccount" /></option>
                <c:forEach var="bankAccount" items="${sessionScope.user.bankAccountList}">
                    <c:if test="${bankAccount.title != 'rainyDay'}">
                        <option value="${bankAccount.id}">${bankAccount.title}</option>
                    </c:if>
                </c:forEach>
            </select>
        </label>
        <button><fmt:message key="label.unit"/></button>
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