<html lang="en" xmlns:th="http://thymeleaf.org">
<title>Hospital Website</title>

<head>
</head>
<body>
<h1 align="center">USERS:</h1>
<div th:each="user : ${users}" align="center">
    <p th:text="${user.toString()}"></p>
</div>
</body>
</html>
