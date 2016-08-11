<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="test.TestSQL" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% request.setCharacterEncoding("UTF-8"); %>
<h1>
    Hello ${param["username"]}
</h1>
<%
    TestSQL t = new TestSQL();
    t.test();
%>
</body>
</html>