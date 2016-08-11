package test;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Юра on 11.08.2016.
 */
public class TestSQL {

    public void test() {
        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/Library");
            Connection conn = ds.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from library.book");
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
