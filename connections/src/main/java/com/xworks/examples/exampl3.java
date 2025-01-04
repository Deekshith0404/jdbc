package com.xworks.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class exampl3 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/branch";
            String user="root";
            String password="root";
            Connection connection=DriverManager.getConnection(url,user,password);
            String query="insert into things value(?,?,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,1);
            preparedStatement.setString(2,"laptop");
            preparedStatement.setString(3,"asus");
            preparedStatement.setString(4,"blue");

            int row=preparedStatement.executeUpdate();
            System.out.println("no of rows executed :"+row);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error is"+e.getMessage());
        }

    }
}
