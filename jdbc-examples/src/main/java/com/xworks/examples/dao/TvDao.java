package com.xworks.examples.dao;

import java.sql.ResultSet;

public interface TvDao {
    int save(int id,String serial_name,String serials_channel,Double serials_trp,int serial_rating,String serial_language);
    ResultSet getDataById(int id);
    int UpdateDataByFields(int id,String name,String channel,double trp,int ratings,String lanaguage);
}
