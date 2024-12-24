package com.xworks.supermarket.runner;
import java.sql.*;
public class example3 {
    public static void main(String[] args) {

        Connection connection=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String urll="jdbc:mysql://localhost:3306/branch";
            String users="root";
            String passwords="root";
            connection=DriverManager.getConnection(urll,users,passwords);
            String insert="insert into mobile_details values(0,'redmi',25000)";

            Statement statement=connection.createStatement();
            int result=statement.executeUpdate(insert);
            System.out.println("number of rows inserted"+result);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
