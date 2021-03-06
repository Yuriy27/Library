package com.github.yuriy27.lib.beans;

import com.github.yuriy27.lib.db.Database;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Book {

    private String name;
    private long id;
    private byte[] content;
    private int pageCount;
    private String isbn;
    private String author;
    private String genre;
    private String publisher;
    private Date publishDate;
    private byte[] image;

    public void loadContent() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = Database.getConnection();
            st = conn.createStatement();
            st.executeUpdate("USE library");
            rs = st.executeQuery("SELECT content FROM book WHERE id=" + getId());
            while (rs.next())
                setContent(rs.getBytes("content"));
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
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
