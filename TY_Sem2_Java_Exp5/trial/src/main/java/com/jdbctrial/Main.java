package com.jdbctrial;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employees";
        String user="root";
        String password="";
        try {
            // Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");   
            //jdbc = java databse CONNECTION = driver 

            Connection conn = DriverManager.getConnection(url,user,password);

            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from workers");
            // ResultSet resultSet = statement.executeQuery("select * from workers where id=1");
            // ResultSet resultSet = statement.executeQuery("insert into workers values(5,'trial',80000)"); INSERT NOT WORKING
            //java.sql.SQLException: Statement.executeQuery() cannot issue statements that do not produce result sets. ????????????????

            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getInt(3));
            }

            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}