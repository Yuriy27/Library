package com.github.yuriy27.lib.db;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;

public class Database {

    public static Connection getConnection() {
        Connection conn = null;
        InitialContext ic;
        DataSource ds;
        try {
            ic = new InitialContext();
            ds = (DataSource) ic.lookup("java:comp/env/jdbc/Library");
            if (conn == null)
                conn = ds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

}
