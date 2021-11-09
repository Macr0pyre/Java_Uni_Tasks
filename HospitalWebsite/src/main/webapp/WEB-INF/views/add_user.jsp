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
    <h1>Here you can add a user</h1>
    <form action="add-user" method="post">
        <table>
            <tr>
                <td>Id</td>
                <td><input type="text" name="id"/></td>
            </tr>
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
                <td><input type="text" name="password"/></td>
            </tr>
        </table>
        <input type="submit" value="Add user"/></form>
</div>
</body>
</html>

