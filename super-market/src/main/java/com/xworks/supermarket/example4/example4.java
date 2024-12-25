package com.xworks.supermarket.example4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
            String insert="insert into laptop_details values(0,'lenovo',45000,8)";
            String insert1="insert into laptop_details values(0,'asus vivobook',53000,12)";
            String insert2="insert into laptop_details values(0,'redmi',35000,6)";
            String insert3="insert into laptop_details values(0,'mac',145000,12)";
            String insert4="insert into laptop_details values(0,'vectus',60000,16)";
            String insert5="insert into laptop_details values(0,'hp',70000,4)";

            statement.addBatch(insert);
            statement.addBatch(insert1);
            statement.addBatch(insert3);
            statement.addBatch(insert4);
            statement.addBatch(insert2);
            statement.addBatch(insert5);

            int[] row=statement.executeBatch();
            System.out.println("number of rows"+row.length);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
