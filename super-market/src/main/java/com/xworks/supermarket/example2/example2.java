package com.xworks.supermarket.example2;

import java.sql.*;


public class example2 {
    public static void main(String[] args) {
        System.out.println("main method running");
        Connection connection=null;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("connection successful");
            String url="jdbc:mysql://localhost:3306/branch";
            String username="root";
            String password="root";
            connection= DriverManager.getConnection(url,username,password);
            System.out.println(" jdbc connected succesfull");
            String insert="insert into country_info values(0,'china','tokyo',15,'virus')";
            String insert1="insert into country_info values(1,'sri lanka','colombo',5,'place')";
            String insert2="insert into country_info values(2,'russia','belin',20,'military')";
            String insert3="insert into country_info values(3,'india','new delhi',120,'street food')";

            Statement statement=connection.createStatement();

            statement.addBatch(insert);
            statement.addBatch(insert1);
            statement.addBatch(insert2);
            statement.addBatch(insert3);
            int[] row=statement.executeBatch();
            System.out.println("no of rows inserted :"+row.length);



        }catch (ClassNotFoundException | SQLException c){
            System.out.println("jdbc class not found"+c.getMessage());

        }
        finally {
            try {
                connection.close();
            }catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
