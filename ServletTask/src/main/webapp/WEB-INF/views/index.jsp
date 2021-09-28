<html>
<title>Servlet App</title>
<body>
<div align="center">
    <h1>Add new student</h1>
    <form action="main" method="post">
        <table>
            <tr>
                <td>Student name</td>
                <td><input type="text" name="name"/></td>
            </tr>
            <tr>
                <td>Average score</td>
                <td><input type="text" name="averageScore"/></td>
            </tr>
            <tr>
                <td>Knows blockchain?</td>
                <td><input type="checkbox" name="knowsBlockchain" value="Knows Blockchain"></td>
            </tr>
        </table>
        <input type="submit" value="Submit"/>
    </form>

    <form action="student-list" method="get">
        <label>Filter by blockchain value</label>
        <input type="checkbox" name="blockchainFilter" value="blockchainFilter">
        <p></p>
        <label>Filter by average score value</label>
        <input type="checkbox" name="averageScoreFilter" value="averageScoreFilter">
        <p></p>
        <input type="submit" value="View student list"/>
    </form>

    <h2>${errorMessage}</h2>
</div>
</body>
</html>