<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=utf-8" %>
<html>
<title>Hospital Website</title>
<head>
    <style type="text/css">
        input[type="submit"] {
            margin-top: 30px;
        }
    </style>
</head>
<body>
<div align="center">
    <h1>Here you can add a doctor</h1>
    <form action="/add-doctor" method="post">
        <table>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name"/></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="email"/></td>
            </tr>
            <tr>
                <td>Login</td>
                <td><input type="text" name="login"/></td>
            </tr>
            <tr>
                <td>Phone number</td>
                <td><input type="text" name="number"/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td>Speciality</td>
                <td>
                    <select name="speciality" id="speciality">
                        <option value=""></option>
                        <c:forEach items="${speciality}" var="option">
                            <option value="${option}">
                                <c:out value="${option.speciality}"></c:out>
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
        </table>
        <input type="submit" value="Add doctor"/></form>
</div>
</body>
</html>