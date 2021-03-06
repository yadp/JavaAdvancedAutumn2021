package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ResultSetClosed {

    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost/world?" +
                            "user=demo&password=12345678");

            // Do something with the Connection


            // assume that conn is an already created JDBC connection (see previous examples)




            stmt = conn.createStatement();
            //rs = stmt.executeQuery("SELECT * FROM country WHERE Continent='Asia' ");
            rs= stmt.executeQuery("SELECT country.name AS Country , city.name as town FROM world.city " +
                    "join world.country on world.city.CountryCode=world.country.Code " +
                    "WHERE city.name='Varna';");
            // or alternatively, if you don't know ahead of time that
            // the query will be a SELECT...

            /*if (stmt.execute("SELECT * FROM country where code='NLD'")) {
                rs = stmt.getResultSet();
            }*/

            List<String> listOfAsia=new ArrayList<>();

            while (rs.next()) {
                //System.out.println(rs.getString("name"));
                System.out.println(rs.getString("country"));
                System.out.println(rs.getString("town"));

            }

            // Now do something with the ResultSet ....
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                } // ignore

                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                } // ignore

                stmt = null;
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
