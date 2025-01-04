package com.xworks.examples.daoImpl;





import com.xworks.examples.dao.TvDao;

import java.sql.*;


public class TvDaoImpl implements TvDao {
    String URL = "jdbc:mysql://localhost:3306/branch";
    String USER = "root";
    String PASS = "root";


    @Override
    public int save(int id, String serial_name, String serials_channel, Double serials_trp, int serial_rating, String serial_language) {


        Connection connection = null;
        PreparedStatement preparedStatemet = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            preparedStatemet = connection.prepareStatement("insert into serials values(?,?,?,?,?,?)");
            preparedStatemet.setInt(1, 0);
            preparedStatemet.setString(2, serial_name);
            preparedStatemet.setString(3, serials_channel);
            preparedStatemet.setDouble(4, serials_trp);
            preparedStatemet.setInt(5, serial_rating);
            preparedStatemet.setString(6, serial_language);


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
            PreparedStatement statement = connection.prepareStatement("select * from serials where id=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int ID = resultSet.getInt(1);
                String serial_name = resultSet.getString(2);
                String serials_channel = resultSet.getString(3);
                Double serials_trp = resultSet.getDouble(4);
                int serial_rating = resultSet.getInt(5);
                String serial_language = resultSet.getString(6);
                System.out.println(" ID:  " + ID + "   Name:  " + serial_name + "  Serial Channel:  " + serials_channel + "   TRP:  " + serials_trp + "  Ratings: " + serial_rating + "   Languages: " + serial_language);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int UpdateDataByFields(int id, String name, String channel, double trp, int ratings, String lanaguage) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement("update serials set  serials_channel=?,serials_trp=?,serial_rating=?,serial_language=? where id=? AND serial_name=?");
            statement.setString(1, channel);
            statement.setDouble(2,trp);
            statement.setInt(3,ratings);
            statement.setString(4,lanaguage);
            statement.setInt(5, id);
            statement.setString(6,name );

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