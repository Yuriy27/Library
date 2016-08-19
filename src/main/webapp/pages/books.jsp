<%@ page import="com.github.yuriy27.lib.beans.Book" %>
<%@ page import="java.util.ArrayList" %>
<%@ include file="../WEB-INF/jspf/left_menu.jspf" %>

<%
    request.setCharacterEncoding("UTF-8");
    long genreId = 0L;
    try {
        genreId = Long.valueOf(request.getParameter("genre_id"));
    } catch (Exception e) {
        e.printStackTrace();
    }
%>

<jsp:useBean id="bookList" class="com.github.yuriy27.lib.beans.BookList" scope="page"/>

<div class="book_list">
    <h3>${param.name}</h3>
    <%
        ArrayList<Book> list = bookList.getBooksByGenre(genreId);
        session.setAttribute("currentBookList", list);
        for (Book book : list) {
    %>
    <div class="book_info">
        <div class="book_title">
            <p> <%=book.getName()%></p>
        </div>
        <div class="book_image">
            <img width="190px" height="250px" src="<%=request.getContextPath()%>/ShowImage?index=<%=list.indexOf(book)%>" alt="Обложка">
        </div>
        <div class="book_details">
            <br><strong>ISBN:</strong> <%=book.getIsbn()%>
            <br><strong>Издательство:</strong> <%=book.getPublisher() %>

            <br><strong>Количество страниц:</strong> <%=book.getPageCount() %>
            <br><strong>Год издания:</strong> <%=book.getPublishDate() %>
            <br><strong>Автор:</strong> <%=book.getAuthor() %>
            <p style="margin:10px;"> <a href="#">Читать</a></p>
        </div>
    </div>
    <% } %>
</div>
