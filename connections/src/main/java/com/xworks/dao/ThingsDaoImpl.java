package com.xworks.dao;

import java.sql.*;

public class ThingsDaoImpl implements  ThingsDao{

    @Override
    public int save(String things, String brand, String color) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/branch";
            String user="root";
            String password="root";
            connection= DriverManager.getConnection(url,user,password);
            String query="insert into things value(?,?,?,?)";
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,0);
            preparedStatement.setString(2,things);
            preparedStatement.setString(3,brand);
            preparedStatement.setString(4,color);

            int row=preparedStatement.executeUpdate();
            return row;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error is"+e.getMessage());
            return 1;
        }
        finally {
            try {
                if (connection!=null) {
                    connection.close();
                }
                if (preparedStatement!=null){
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    @Override
    public ResultSet getAll() {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/branch";
            String user="root";
            String password="root";
            connection= DriverManager.getConnection(url,user,password);
            String query="select * from things";
            preparedStatement=connection.prepareStatement(query);
            ResultSet resultSet=preparedStatement.executeQuery();
            return resultSet;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error is"+e.getMessage());
            return null;
        }

        }

    }


