package com.xworks.supermarket.example3;
import java.sql.*;
public class FindById {
    public static void main(String[] args) {

    Connection connection=null;
    Statement statement=null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/branch";
        String username="root";
        String password="root";
        connection= DriverManager.getConnection(url,username,password);
        statement=connection.createStatement();
        String query="select * from mobile_details where mobile_id=2";
        ResultSet resultSet=statement.executeQuery(query);
        while (resultSet.next()){
            int id=resultSet.getInt(1);
            String name=resultSet.getString(2);
            double cost=resultSet.getDouble(3);
            System.out.println("Mobile_id :"+id+"  mobile_name:"+name+"  cost:"+cost);
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
