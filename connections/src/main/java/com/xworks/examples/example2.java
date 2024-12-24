package com.xworks.examples;

import java.sql.DriverManager;
import java.sql.SQLException;

public class example2 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/branch";
            String user="root";
            String password="root";
            DriverManager.getConnection(url,user,password);
            System.out.println("connection success full");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error is :"+e.getMessage());
        }
    }
}
