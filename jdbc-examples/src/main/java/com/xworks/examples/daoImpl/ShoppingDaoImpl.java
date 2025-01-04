package com.xworks.examples.daoImpl;

import com.xworks.examples.dao.ShoppingDao;

import java.sql.*;

public class ShoppingDaoImpl implements ShoppingDao {
    String URL = "jdbc:mysql://localhost:3306/branch";
    String USER = "root";
    String PASS = "root";
    @Override
    public int save(int id, String shop_name, String shopKeeper_name, String shop_location, String purchased_item, int item_cost) {
        Connection connection = null;
        PreparedStatement preparedStatemet = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            preparedStatemet = connection.prepareStatement("insert into shop values(?,?,?,?,?,?)");
            preparedStatemet.setInt(1, id);
            preparedStatemet.setString(2, shop_name);
            preparedStatemet.setString(3,shopKeeper_name );
            preparedStatemet.setString(4,shop_location );
            preparedStatemet.setString(5, purchased_item);
            preparedStatemet.setInt(6,item_cost );


            int row = preparedStatemet.executeUpdate();
            System.out.println("no of rows inserted: " + row);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                } else if (preparedStatemet != null) {
                    connection.close();
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
        return 0;
    }

    @Override
    public ResultSet getDataById(int id) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement statement = connection.prepareStatement("select * from shop where id=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int ID = resultSet.getInt(1);
                String shop_name = resultSet.getString(2);
                String shopKeeper_name = resultSet.getString(3);
                String  shop_location = resultSet.getString(4);
                String purchased_item = resultSet.getString(5);
                int item_cost = resultSet.getInt(6);
                System.out.println(" ID:  " + ID + "  Shop  Name:  " + shop_name + "  Shop keeper Name:  " + shopKeeper_name + "   Location:  " +  shop_location+ "  Purchased item : " + purchased_item + "   Item cost: " + item_cost);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int UpdatebyField(int id, String shop_name, String shopKeeper_name, String shop_location, String purchased_item, int item_cost) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement("update shop set shopKeeper_name=?, shop_location=?,purchased_item=?,item_cost=? where id=? And shop_name=?");
            statement.setInt(5, id);
            statement.setString(6,shop_name );
            statement.setString(1, shopKeeper_name);
            statement.setString(2,shop_location);
            statement.setString(3,purchased_item);
            statement.setInt(4,item_cost);
            int row = statement.executeUpdate();

            connection.commit();
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
}