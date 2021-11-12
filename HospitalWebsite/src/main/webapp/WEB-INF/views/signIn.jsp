<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<div align="center">
    <h1>Here you can sign in</h1>
    <c:if test="${param.error != null}">
        <p>Invalid username / password</p>
    </c:if>
    <form method="POST" action="/sign-in">
        <p><label for="login">Login:</label></p>
        <input type="text" id="login" name="login" placeholder="Login"/>

        <p><label for="password">Password:</label></p>
        <input type="password" id="password" name="password" placeholder="Password">

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <p><input type="submit" value="Sign in" /></p>
    </form>
</div>
</body>
</html>