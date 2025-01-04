package com.xworks.examples.dao;

import java.sql.ResultSet;

public interface BusStopDao {
    int save(String busstop_name,String location,int noOfBus,String starting,String destination,String status);
    ResultSet getAllData();
    ResultSet getDataById(int id);
    int updateByField( int id,String busstop_name,String location,int noOfBus,String starting,String destination,String status );
    int updateByAnd( int id,String busstop_name,String location,int noOfBus,String starting,String destination,String status );
    int updateByOr( int id,String busstop_name,String location,int noOfBus,String starting,String destination,String status );
    ResultSet activeBus();
    boolean deleteById(int Id);

}