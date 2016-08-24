<%@ page import="com.github.yuriy27.lib.beans.Book" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.github.yuriy27.lib.enums.SearchType" %>

<%@ include file="../WEB-INF/jspf/left_menu.jspf" %>
<%@ include file="../WEB-INF/jspf/letters.jspf" %>

<jsp:useBean id="bookList" class="com.github.yuriy27.lib.beans.BookList" scope="page"/>

<%
    request.setCharacterEncoding("UTF-8");
    ArrayList<Book> list = null;

    try {
        if (request.getParameter("letter") != null) {
            String letter = request.getParameter("letter");
            list = bookList.getBooksByLetter(letter);
        } else {
            if (request.getParameter("search_string") != null) {
                String search = request.getParameter("search_string");
                SearchType type = SearchType.TITLE;
                if (request.getParameter("search_option").equals("Автор")) {
                    type = SearchType.AUTHOR;
                }
                list = bookList.getBooksBySearch(search, type);
            } else {
                long genreId = 0L;
                genreId = Long.valueOf(request.getParameter("genre_id"));
                list = bookList.getBooksByGenre(genreId);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
%>

<div class="book_list">
    <h3>${param.name}</h3>
    <h6>Найдено книг: <%=list.size()%></h6>
    <%
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
