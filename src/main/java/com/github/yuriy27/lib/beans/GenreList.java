package com.github.yuriy27.lib.beans;

import com.github.yuriy27.lib.db.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Юра on 14.08.2016.
 */
public class GenreList {

    private ArrayList<Genre> genreList = new ArrayList<Genre>();

    /*private static GenreList instance;

    public static GenreList getInstance() {
        if (instance == null)
            instance = new GenreList();
        return instance;
    }

    private GenreList() {
        genreList = new ArrayList<Genre>();
    }*/

    private ArrayList<Genre> getGenres() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = Database.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM library.genre ORDER BY name");
            while (rs.next()) {
                Genre genre = new Genre(rs.getString("name"), rs.getLong("id"));
                genreList.add(genre);
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

        return genreList;
    }

    public ArrayList<Genre> getGenreList() {
        if (!genreList.isEmpty())
            return genreList;
        return getGenres();
    }

}
