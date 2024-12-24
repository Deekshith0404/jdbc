package com.xworks.supermarket.retriver;

import java.sql.*;

public class Example2Retriver {
    public static void main(String[] args) {

        Connection connection=null;
        Statement statement=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/branch";
            String username="root";
            String password="root";
            connection=DriverManager.getConnection(url,username,password);
            statement=connection.createStatement();
            String query="select * from country_info";
            ResultSet resultSet=statement.executeQuery(query);
            while (resultSet.next()){
                int id=resultSet.getInt(1);
                String name=resultSet.getString(2);
                String capital=resultSet.getString(3);
                int population=resultSet.getInt(4);
                String famous=resultSet.getString(5);
                System.out.println("country id :"+id+"  country name :"+name+"  country capital :"+capital+"  population:"+population+"  famous for "+famous);

            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            try {
                if (connection!=null) {
                    connection.close();
                }
                if (statement!=null){
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
