<%@ page import="org.model.Student" %>
<%@ page import="java.util.List" %>
<html>
<title>Servlet App</title>
<body>
<div align="center">
    <h1>Student list</h1>
    <table>
        <thead>
        <tr>
            <th>#</th>
            <th>Имя</th>
            <th>Средняя оценка</th>
            <th>Знает блокчейн</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Student> students = (List) request.getAttribute("list");
        %>

        <%
            for (Student s : students) {
        %>
        <tr>
            <td><%=s.getName()%>
            </td>
            <td><%=s.getAverageScore()%>
            </td>
            <td><%=s.isKnowsBlockchain()%>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <form action="stud-servlet" method="get">
        <input type="submit" value="Go back"/></form>
</div>
</body>
</html>