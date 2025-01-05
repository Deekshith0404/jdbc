package com.xworkz.broke.service;

import java.time.LocalDate;

public interface EcommerceService {

    boolean validateAndSave(String productName, String productBrand, String productModel, LocalDate mfgDate, Double price, String currency);

    void findById(int id);

    void findByIdModel(int id, String productModel);

    void countByCurrency(String currency);

    void productNameAndBrand(String productName, String productBrand);

    boolean updatePriceById(int id, double price);

    boolean updateBrandByid(int id, String brand);

    boolean deleteById(int id);
}
