package com.xworkz.broke.dao;

import java.sql.ResultSet;
import java.time.LocalDate;

public interface EcommerceDao {

    int validateAndSave(String productName, String productBrand, String productModel, LocalDate mfgDate, Double price, String currency);

    ResultSet findById(int id);

    ResultSet findByIdModel(int id, String productModel);

    int countByCurrency(String currency);

    ResultSet productNameAndBrand(String productName, String productBrand);

    int updatePriceById(int id, double price);

    int updateBrandByid(int id, String brand);

    int deleteById(int id);


}
