<%--
  Created by IntelliJ IDEA.
  User: Юра
  Date: 04.08.2016
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Online Library</title>
    <link href="css/style_index.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="main">
        <div class="content">
            <p class="text"><img vspace="10" hspace="20" src="img/lib_icon.png" width="90" height="90"></p>
            <p class="text">Онлайн библиотека</p>
        </div>
        <div class="login">
            <form class="form" action="pages/main.jsp" method="post">
                <input type="text" name="username" class="name_inp">
                <button class="btn" type="submit">Войти</button>
            </form>
        </div>
        <div class="footer">
            Developer: Yuriy Kuchevskiy 2016
        </div>
    </div>
</body>
</html>

