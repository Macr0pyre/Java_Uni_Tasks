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
    <h1>Here you can update your account</h1>
    <form action="/user/update-user" method="post">
        <table>
            <tr>
                <td>Select parameter to change</td>
                <td>
                    <select name="parameter">
                        <option value="name">Name</option>
                        <option value="number">Number</option>
                        <option value="email">Email</option>
                        <option value="password">Password</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>New parameter value</td>
                <td><input type="text" name="newValue"/></td>
            </tr>
        </table>
        <input type="submit" value="Update user"/></form>
</div>
</body>
</html>

