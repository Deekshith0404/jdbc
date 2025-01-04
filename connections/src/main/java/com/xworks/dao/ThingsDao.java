package com.xworks.dao;

import java.sql.ResultSet;

public interface ThingsDao {
    int save(String things,String brand,String color);

    ResultSet getAll();
}
