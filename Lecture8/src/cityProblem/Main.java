package cityProblem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost/world?" +
                            "user=demo&password=12345678");


            stmt = conn.createStatement();

            rs = stmt.executeQuery("SELECT country.name AS Country , " +
                    "city.name as city, " +
                    "city.Population as Population " +
                    "FROM world.city " +
                    "JOIN world.country on world.city.CountryCode=world.country.Code " +
                    "WHERE city.Population > 1000000;");


            List<City> listOfCity = new ArrayList<>();

            while (rs.next()) {

                //System.out.println(rs.getString("country"));
                //System.out.println(rs.getString("city"));
                //System.out.println(rs.getLong("Population"));
                City cityToAdd= new City(rs.getString("city"),
                        rs.getString("country"),
                        rs.getInt("Population"));

                System.out.println(rs.getLong("Population"));
                listOfCity.add(cityToAdd);
            }

            System.out.println(listOfCity);
            System.out.println(listOfCity.size());

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
