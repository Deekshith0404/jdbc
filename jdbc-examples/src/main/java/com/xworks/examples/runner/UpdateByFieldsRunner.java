package com.xworks.examples.runner;


import com.xworks.examples.dao.BusStopDao;
import com.xworks.examples.daoImpl.BusStopDaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateByFieldsRunner {
    private static BusStopDao busStopDao=new BusStopDaoImpl();
    public static void main(String[] args) {

//        busStopDao.save("rr nagar","rr",211,"majestic","mysore","inactive");
//        int update=busStopDao.updateByField(3,"nagasandra","banglore",45,"Rajajinagar","peenya","active");
//        System.out.println(update+": 3rd Row updated");
//
//        int updatedBy2Field=busStopDao.updateByAnd(4,"hasaan","banglore",45,"malleshwaram","vijaynagar");
//        System.out.println(updatedBy2Field+": 4th Row updated by using AND operation");
//
//        int updateOr=busStopDao.updateByOr(2,"Bus Nildana","banglore",90,"peenya","rajajinagar");
//        System.out.println(updateOr+": 2nd Row updated by using OR operation ");
//        ResultSet resultSet=busStopDao.getAllData();
//        try {
//            while (resultSet.next()){
//                int id=resultSet.getInt(1);
//                 String name=resultSet.getString(2);
//                String location=resultSet.getString(3);
//                int busnum=resultSet.getInt(4);
//                String start=resultSet.getString(5);
//                String end=resultSet.getString(6);
//                String status=resultSet.getString(7);
//                System.out.println("bus id :"+id+"     busStop Name:"+name+"    Stop loacation:"+location+"     Bus number:"+busnum+"   stating point :"+start+"    ending point :"+end+"   Status :"+status);
//
//
//            }
//        }catch (SQLException E){
//            System.out.println(E.getMessage());
//
//        }

//        ResultSet resultSet1=busStopDao.activeBus();
//        try {
//            while (resultSet1.next()){
//                int id=resultSet1.getInt(1);
//                String name=resultSet1.getString(2);
//                String location=resultSet1.getString(3);
//                int busnum=resultSet1.getInt(4);
//                String start=resultSet1.getString(5);
//                String end=resultSet1.getString(6);
//                String status=resultSet1.getString(7);
//                System.out.println("bus id :"+id+"     busStop Name:"+name+"    Stop loacation:"+location+"     Bus number:"+busnum+"   stating point :"+start+"    ending point :"+end+"   Status :"+status);
//
//
//            }
//        }catch (SQLException E){
//            System.out.println(E.getMessage());
//
//        }
        int id=2;
        boolean result=busStopDao.deleteById(id);
        if (result){
            System.out.println("data deleted of id: "+id);
        }else {
            System.out.println("not deleted");
        }



    }
}