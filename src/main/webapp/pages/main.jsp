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
            <div class="title">
                <div class="logo">
                    <img alt="logo" name="logo" width="100%" src="../img/lib_icon.png">
                </div>
                <div class="desc">
                    <h3>Онлайн библиотека</h3>
                </div>
            </div>
            <div class="search_div">
                <form name="search_form" method="post">
                    <!--<img style="padding-left: 20px" src="../img/search.jpg" width="32">-->
                    <input class="search_string" type="text" name="search_string" value="" size="100">
                    <input class="search_btn" type="submit" name="search_btn" value="Поиск">
                    <select name="search_option">
                        <option>Автор</option>
                        <option>Название</option>
                    </select>
                </form>
            </div>
        </div>

        <div class="sidebar1">
            <h4>Список авторов:</h4>
            <ul class="nav">
                <%
                    AuthorList authorList = AuthorList.getInstance();
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

        <div class="content">
            <h1>&nbsp;</h1>
            <p>&nbsp;</p>
        </div>

    </div>
</body>
</html>