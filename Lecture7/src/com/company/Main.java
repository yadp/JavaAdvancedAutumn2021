package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
	// write your code here


        Connection connection = null;
        try {
            connection= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/world","java","12345678"
            );

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select DISTINCT name from country LIMIT 100;");

            System.out.println("Number of columns " + resultSet.getMetaData().getColumnCount());


            while (resultSet.next()){
                System.out.println(resultSet.getString(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }

    }
}
