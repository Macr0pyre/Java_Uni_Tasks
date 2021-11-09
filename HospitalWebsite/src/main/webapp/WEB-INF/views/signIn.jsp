<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<div align="center">
    <h1>Вход в аккаунт</h1>
    <c:if test="${param.error != null}">
        <p>Invalid username / password</p>
    </c:if>
    <form method="POST" action="/app/sign-in">
        <p><label for="login">Логин:</label></p>
        <input type="text" id="login" name="login" placeholder="Login"/>

        <p><label for="password">Пароль:</label></p>
        <input type="password" id="password" name="password" placeholder="Password">

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <p><input type="submit" value="Войти" /></p>
    </form>
</div>
</body>
</html>