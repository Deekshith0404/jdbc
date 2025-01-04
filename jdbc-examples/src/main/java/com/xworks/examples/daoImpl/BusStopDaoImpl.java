package com.xworks.examples.daoImpl;
import com.xworks.examples.dao.BusStopDao;

import java.sql.*;

public class BusStopDaoImpl implements BusStopDao {

    String URL = "jdbc:mysql://localhost:3306/branch";
    String USER = "root";
    String PASS = "root";

    @Override
    public int save(String busstop_name, String busstop_location, int noofbus, String bus_starting, String bus_destination,String status) {
        Connection connection = null;
        PreparedStatement preparedStatemet = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            preparedStatemet = connection.prepareStatement("insert into Busstop values(?,?,?,?,?,?,?)");
            preparedStatemet.setInt(1, 0);
            preparedStatemet.setString(2, busstop_name);
            preparedStatemet.setString(3, busstop_location);
            preparedStatemet.setInt(4, noofbus);
            preparedStatemet.setString(5, bus_starting);
            preparedStatemet.setString(6, bus_destination);
            preparedStatemet.setString(7, status);



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
    public ResultSet getAllData() {

        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement statement = connection.prepareStatement("select *from Busstop");
            ResultSet resultSet = statement.executeQuery();
            return resultSet;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ResultSet getDataById(int id) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement statement = connection.prepareStatement("select * from Busstop where id=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public int updateByField( int id,String busstop_name, String location, int noOfBus, String starting, String destination,String status) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement("update Busstop set  busstop_name=?,busstop_location=?,noofbus=?,bus_starting=?,bus_destination=?,status=? where id=? ");
            statement.setInt(6, id);
            statement.setString(1,busstop_name );
            statement.setString(2, location);
            statement.setInt(3,noOfBus);
            statement.setString(4,starting);
            statement.setString(5,destination);
            statement.setString(6,status);

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

    @Override
    public int updateByAnd(int id, String busstop_name, String location, int noOfBus, String starting, String destination,String status) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement("update Busstop set  busstop_location=?,noofbus=?,bus_starting=?,bus_destination=?,status=? where id=? AND busstop_name=?");
            statement.setInt(5, id);
            statement.setString(6,busstop_name );
            statement.setString(1, location);
            statement.setInt(2,noOfBus);
            statement.setString(3,starting);
            statement.setString(4,destination);
            statement.setString(7,status);
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

    @Override
    public int updateByOr(int id, String busstop_name, String location, int noOfBus, String starting, String destination,String status) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            connection.setAutoCommit(false);
            PreparedStatement selectStatement = connection.prepareStatement("SELECT * FROM Busstop WHERE id=? OR busstop_name=?");
            PreparedStatement statement = connection.prepareStatement("update Busstop set  busstop_location=?,noofbus=?,bus_starting=?,bus_destination=?,status=? where id=? OR busstop_name=?");
            statement.setInt(5, id);
            statement.setString(6,busstop_name );
            statement.setString(1, location);
            statement.setInt(2,noOfBus);
            statement.setString(3,starting);
            statement.setString(4,destination);
            statement.setString(7,status);
            selectStatement.setInt(1, id);
            selectStatement.setString(2, busstop_name);
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

    @Override
    public ResultSet activeBus() {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement statement = connection.prepareStatement("select * from Busstop where status=?");
            statement.setString(1, "active");
            ResultSet resultSet = statement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public boolean deleteById(int Id) {
        Connection connection=null;
        try {
            connection=DriverManager.getConnection(URL,USER,PASS);
            connection.setAutoCommit(false);
            PreparedStatement statement=connection.prepareStatement("delete from busstop where id=?");
            statement.setInt(1,Id);
            boolean result=statement.execute();
            connection.commit();
            return result;

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                System.out.println(e.getMessage());
            }
            System.out.println(e.getMessage());
            return false;
        }
    }
}
