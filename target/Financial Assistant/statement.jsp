<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<fmt:setLocale value="${cookie['language'].value}"/>
<fmt:setBundle basename="language"/>

<html>
<head>
    <title><fmt:message key="label.statement"/></title>
</head>
<body>
<div>

    <h6><a href="${pageContext.request.contextPath}/languageButton?language=ru">ru</a>
        <a>|</a>
        <a href="${pageContext.request.contextPath}/languageButton?language=en">en</a></h6>
    <h1><a href="${pageContext.request.contextPath}/">Financial assistant</a></h1>

    <ul>
        <li><a href="${pageContext.request.contextPath}/"><fmt:message key="label.bankAccounts"/> </a>
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
        <li><a href="${pageContext.request.contextPath}/profile/unitBankAccounts"><fmt:message key="label.unit"/>
            <fmt:message key="label.bankAccount"/> </a></li>
        <li><a href="${pageContext.request.contextPath}/profile/edit"><fmt:message key="label.edit"/></a></li>
    </ul>
    <p></p>
    <p></p>
    <p></p>
    <table class="table_dark">
        <tr>
            <th>Description</th>
            <th>Date&Time</th>
            <th>Type</th>
            <th>Money</th>
        </tr>
        <c:forEach var="operation" items="${requestScope.bankAccount.operations}">
            <tr>
                <td>${operation.description}</td>
                <td>${operation.dateTime}</td>
                <td>${operation.type}</td>
                <td>${operation.money}</td>
            </tr>
        </c:forEach>
    </table>
    <form action="${pageContext.request.contextPath}/sendEmailStatementButton">
        <input type="hidden" name="id" value="${requestScope.bankAccount.id}">
        <button><fmt:message key="label.sendToMail"/></button>
    </form>
</div>
</body>
<style>
    .table_dark {
        font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
        font-size: 14px;
        width: 640px;
        text-align: left;
        border-collapse: collapse;
        background: #252F48;
        margin: 10px;
    }

    .table_dark th {
        color: #EDB749;
        border-bottom: 1px solid #37B5A5;
        padding: 12px 17px;
    }

    .table_dark td {
        color: #CAD4D6;
        border-bottom: 1px solid #37B5A5;
        border-right: 1px solid #37B5A5;
        padding: 7px 17px;
    }

    .table_dark tr:last-child td {
        border-bottom: none;
    }

    .table_dark td:last-child {
        border-right: none;
    }

    .table_dark tr:hover td {
        text-decoration: underline;
    }
</style>
</html>
