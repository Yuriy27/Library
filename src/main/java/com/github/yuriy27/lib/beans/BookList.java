package com.github.yuriy27.lib.beans;

import com.github.yuriy27.lib.db.Database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Юра on 14.08.2016.
 */
public class BookList {

    private ArrayList<Book> bookList = new ArrayList<Book>();

    /*private static BookList instance;

    private BookList() {
        bookList = new ArrayList<Book>();
    }

    public static BookList getInstance() {
        if (instance == null)
            instance = new BookList();
        return instance;
    }*/

    private ArrayList<Book> getBooks(String query) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = Database.getConnection();
            st = conn.createStatement();
            st.executeUpdate("USE library");
            rs = st.executeQuery(query);
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getLong("id"));
                book.setName(rs.getString("name"));
                book.setGenre(rs.getString("genre"));
                book.setIsbn(rs.getString("isbn"));
                book.setAuthor(rs.getString("author"));
                book.setPageCount(rs.getInt("page_count"));
                book.setPublishDate(rs.getDate("publish_year"));
                book.setPublisher(rs.getString("publisher"));
                book.setImage(rs.getBytes("image"));
                bookList.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null)
                    st.close();
                if (rs != null)
                    rs.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return bookList;
    }

    private ArrayList<Book> getAllBooks() {
        if (!bookList.isEmpty())
            return bookList;
        return getBooks("SELECT * FROM library.book ORDER BY name");
    }

    public ArrayList<Book> getBooksByGenre(long id) {
        return getBooks("select b.id,b.name,b.isbn,b.page_count,b.publish_year, p.name as publisher, a.fio as author, g.name as genre, b.image from library.book b "
                + "inner join author a on b.author_id=a.id "
                + "inner join genre g on b.genre_id=g.id "
                + "inner join publisher p on b.publisher_id=p.id "
                + "where genre_id=" + id + " order by b.name "
                + "limit 0,5");
    }

}
