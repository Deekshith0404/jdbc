package com.xworkz.broke.dao;

import java.sql.*;
import java.time.LocalDate;

public class EcommerceDaoImpl implements EcommerceDao {
    private Connection connection=null;
    private final String URL = "jdbc:mysql://localhost:3306/branch";
    private final String USER = "root";
    private final String PASS = "root";




    @Override
    public int validateAndSave(String productName, String productBrand, String productModel, LocalDate mfgDate, Double price, String currency) {

        try {
            connection = DriverManager.getConnection(URL,USER,PASS);
            connection.setAutoCommit(false);
            PreparedStatement prepareStatement = connection.prepareStatement("insert into ecommerce values (?,?,?,?,?,?,?)");
            prepareStatement.setInt(1, 0);
            prepareStatement.setString(2, productName);
            prepareStatement.setString(3, productBrand);
            prepareStatement.setString(4, productModel);
            prepareStatement.setDate(5, Date.valueOf(mfgDate));
            prepareStatement.setDouble(6,price);
            prepareStatement.setString(7, currency);
            int row=prepareStatement.executeUpdate();
            connection.commit();
            System.out.println("number of row inserted"+row);
            return row;

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                System.out.println(e.getMessage());

            }
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public ResultSet findById(int id) {
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement statement = connection.prepareStatement("select * from ecommerce where id=?");
            statement.setInt(1,id);
            return statement.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ResultSet findByIdModel(int id, String productModel) {
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement statement = connection.prepareStatement("select * from ecommerce where id=? and productModel=?");
            statement.setInt(1, id);
            statement.setString(2, productModel);
            ResultSet resultSet=statement.executeQuery();
            return resultSet;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public int countByCurrency(String currency) {

        try {
            this.connection = DriverManager.getConnection(URL,USER,PASS);
            PreparedStatement statement = connection.prepareStatement("select count(*)  from ecommerce where currency=?");
            statement.setString(1, currency);
            ResultSet rest=statement.executeQuery();
            if (rest.next()){
                int count=rest.getInt(1);
                return count;

            }
            return 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return 0;
    }

    @Override
    public ResultSet productNameAndBrand(String productName, String productBrand) {
        try {
            this.connection = DriverManager.getConnection(URL,USER,PASS);
            PreparedStatement statement = connection.prepareStatement("select * from ecommerce where productName=? AND productBrand=?");
            statement.setString(1, productName);
            statement.setString(2, productBrand);
            ResultSet resultSet=statement.executeQuery();
            return resultSet;



        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return null;
    }

    @Override
    public int updatePriceById(int id, double price) {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement statement = connection.prepareStatement("update ecommerce set price=? where id=?");
            statement.setInt(2, id);
//            statement.setString(1, Double.valueOf(price).toString());
            statement.setDouble(1,price);

            int row=statement.executeUpdate();
            System.out.println("no of rows upated :" +row);
            return row;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int updateBrandByid(int id, String productBrand) {
        try {
            this.connection = DriverManager.getConnection(URL,USER,PASS);
            PreparedStatement statement = connection.prepareStatement("update ecommerce set productBrand=? where id=?");
            statement.setString(1, productBrand);
            statement.setInt(2, id);
            int row=statement.executeUpdate();
            System.out.println("number of row updated :"+row);
            return row;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public int deleteById(int id) {
        try {
            this.connection = DriverManager.getConnection(URL,USER,PASS);
            PreparedStatement statement = connection.prepareStatement("delete from ecommerce where id=?");
            statement.setInt(1,id);
            int row=statement.executeUpdate();
            System.out.println("number of rows deleted "+row);
            return row;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }


}
