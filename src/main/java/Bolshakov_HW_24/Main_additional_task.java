package Bolshakov_HW_24;

import java.sql.*;

public class Main_additional_task {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String create_table = "CREATE TABLE Cars5 (\n" +
                "\tName varchar(255),\n" +
                "\tColor varchar(255),\n" +
                "\tYear int,\n" +
                "\tPrice int);";

        String add_data = "INSERT INTO Cars5 \n" +
                "\t(Name, Color, Year, Price)\n" +
                "VALUES \n" +
                "\t('Car 1', 'Green', 2010, 10000),\n" +
                "\t('Car 2', 'Yellow', 2011, 11000),\n" +
                "\t('Car 3', 'Red', 2012, 12000),\n" +
                "\t('Car 4', 'Black', 2013, 13000),\n" +
                "\t('Car 5', 'White', 2014, 14000);";

        String data_update = "UPDATE Cars5\n" +
                "SET name = CONCAT(name, '+');";

        String select_sql = "SELECT * FROM Cars5";

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "docker");
        Statement statement = connection.createStatement();

        statement.execute(create_table);
        statement.execute(add_data);
        statement.execute(data_update);

        ResultSet rs = statement.executeQuery(select_sql);
        while (rs.next()) {
            if (rs.getString(1).contains("+")) {
                System.out.printf("%s | %s | %s | %s | - changed %n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
            } else {
                System.out.printf("%s | %s | %s | %s | - not changed %n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
            }
        }
        connection.close();
    }
}
