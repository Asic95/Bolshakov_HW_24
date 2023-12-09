package Bolshakov_HW_24;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String select_sql = "SELECT * FROM CARS";

        //"create database test;"

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "docker");
        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery(select_sql);
        while (rs.next()) {
            System.out.printf("%s | %s | %s | %s |%n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
        }
        connection.close();
    }
}
