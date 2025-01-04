package com.xworks.examples;

import com.xworks.dao.ThingsDao;
import com.xworks.dao.ThingsDaoImpl;
import com.xworks.service.ThingsService;
import com.xworks.service.ThingsServiceImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ThingsRunner {
    public static void main(String[] args) {
        ThingsService thingsService=new ThingsServiceImpl();
        boolean save=thingsService.validationSave("mobile","iqoo","blue");
        if (save){
            System.out.println("data saved");
        }else {
            System.out.println("not saved");
        }

//        int row=thingsDao.save("projector","samsung","white");
//        Syst  em.out.println("the number of rows is"+row);
//
//        ResultSet resultSet=thingsDao.getAll();
//        try {
//            while (resultSet.next()) {
//                int id=resultSet.getInt(1);
//                String name=resultSet.getString(2);
//                String brand=resultSet.getString(3);
//                String  color=resultSet.getString(4);
//                System.out.println("Id num:"+id+"  name:"+name+"   brand:"+brand+"   color:"+color);
//
//            }
//        }catch (SQLException e){
//            System.out.println(e.getMessage());
//        }
    }
}
