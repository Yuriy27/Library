package com.github.yuriy27.lib.beans;

import com.github.yuriy27.lib.db.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Юра on 13.08.2016.
 */
public class AuthorList {

    private ArrayList<Author> authorList;

    private static AuthorList instance;

    public static AuthorList getInstance() {
        if (instance == null) {
            instance = new AuthorList();
        }
        return instance;
    }

    private AuthorList() {
        authorList = new ArrayList<Author>();
    }

    public ArrayList<Author> getAuthors() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = Database.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select * from library.author ORDER by fio");
            while (rs.next()) {
                Author author = new Author(rs.getString("fio"));
                authorList.add(author);
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
        return authorList;
    }

    public ArrayList<Author> getAuthorList() {
        if (!authorList.isEmpty())
            return authorList;
        return getAuthors();
    }

}
