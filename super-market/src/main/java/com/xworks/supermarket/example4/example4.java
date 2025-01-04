package com.xworks.supermarket.example4;

import java.sql.*;

public class example4 {
    public static void main(String[] args) {
        Connection connection=null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/branch";
            String user="root";
            String pass="root";
            connection=DriverManager.getConnection(url,user,pass);
            Statement statement=connection.createStatement();

            String query="select count(*) from laptop_details where laptop_price>50000";
            ResultSet resultSet=statement.executeQuery(query);
            resultSet.next();
            System.out.println(resultSet.getInt(1));

            String query1="select count(*) from laptop_details where laptop_name='lenovo'";
            ResultSet resultSet1=statement.executeQuery(query1);
            resultSet1.next();
            System.out.println(resultSet1.getInt(1));
//            String insert="insert into laptop_details values(0,'lenovo',45000,8)";
//            String insert1="insert into laptop_details values(0,'asus vivobook',53000,12)";
//            String insert2="insert into laptop_details values(0,'redmi',35000,6)";
//            String insert3="insert into laptop_details values(0,'mac',145000,12)";
//            String insert4="insert into laptop_details values(0,'vectus',60000,16)";
//            String insert5="insert into laptop_details values(0,'hp',70000,5)";
//            String insert6="insert into laptop_details values(0,'asus',60000,9)";
//            String insert7="insert into laptop_details values(0,'dell',25000,3)";
//            String insert8="insert into laptop_details values(0,'micro soft',70000,16)";
//            String insert9="insert into laptop_details values(0,'samsung',45000,8)";
//            String insert10="insert into laptop_details values(0,'lenovo',17000,6)";
//
//
//            statement.addBatch(insert);
//            statement.addBatch(insert1);
//            statement.addBatch(insert3);
//            statement.addBatch(insert4);
//            statement.addBatch(insert2);
//            statement.addBatch(insert5);
//            statement.addBatch(insert6);
//            statement.addBatch(insert7);
//            statement.addBatch(insert8);
//            statement.addBatch(insert9);
//            statement.addBatch(insert10);

//            int[] row=statement.executeBatch();
//            System.out.println("number of rows"+row.length);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
