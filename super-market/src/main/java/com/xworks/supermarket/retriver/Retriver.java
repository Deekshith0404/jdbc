package com.xworks.supermarket.retriver;
import java.sql.*;
public class Retriver {
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
            resultSet.next();
            System.out.println(" id:"+resultSet.getInt(1)+"  name:"+resultSet.getString(2)+" capital:"+resultSet.getString(3)+"  popoulation:"+resultSet.getInt(4)+"  famous for:"+resultSet.getString(5));
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
