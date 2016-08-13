<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="test.TestSQL" %>
<%@ page import="com.github.yuriy27.lib.beans.AuthorList" %>
<%@ page import="com.github.yuriy27.lib.beans.Author" %>
<html>
<head>
    <title>Онлайн библиотека</title>
    <link href="../css/style_main.css" rel="stylesheet" type="text/css">
</head>
<body>

<% request.setCharacterEncoding("UTF-8"); %>
    <div class="container">

        <div class="header">
            <img alt="logo" name="logo"  height="90" width="100%">
            <form class="search_form" name="search_form" method="post">
                <img src="../img/search.jpg" width="32">
                <input type="text" name="search_string" value="" size="100">
                <input type="submit" name="search_btn" value="Поиск">
                <select name="search_option">
                    <option>Автор</option>
                    <option>Название</option>
                </select>
            </form>
        </div>

        <div class="sidebar1">
            <h4>Список авторов</h4>>
            <ul class="nav">
                <%
                    AuthorList authorList = new AuthorList();
                    for (Author author : authorList.getAuthorList()) {
                %>
                <li>
                    <a href="#">
                        <%=author.getName()%>
                    </a>
                </li>
                <% } %>
            </ul>
            <p>&nbsp;</p>
        </div>

    </div>
</body>
</html>