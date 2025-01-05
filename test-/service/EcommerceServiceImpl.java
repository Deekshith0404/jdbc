package com.xworkz.broke.service;

import com.xworkz.broke.dao.EcommerceDao;
import com.xworkz.broke.dao.EcommerceDaoImpl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class EcommerceServiceImpl implements EcommerceService {
    private EcommerceDao ecommerceDao = new EcommerceDaoImpl();

    @Override
    public boolean validateAndSave(String productName, String productBrand, String productModel, LocalDate mfgDate, Double price, String currency) {
        boolean isProductName = true;
        boolean isProductBrand = true;
        boolean isProductModel = true;
        boolean isMfgDate = true;
        boolean isPrice = true;
        boolean isCurrency = true;
        if (isProductName && isProductBrand && isProductModel && isMfgDate && isPrice && isCurrency) {
            int integer = ecommerceDao.validateAndSave(productName, productBrand, productModel, mfgDate, price, currency);
            if (integer > 0) {
                System.out.println("Valid all fields data to be saved");
                return true;
            } else {
                System.out.println("inValid  fields data ");
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public void findById(int id) {
        ResultSet resultSet = ecommerceDao.findById(id);
        try {
//            resultSet.next();
            while (resultSet.next()) {
                System.out.println("Print all data");
                int id1=resultSet.getInt(1);
                String name=resultSet.getString(2);
                String brand=resultSet.getString(3);
                String model=resultSet.getString(4);
                double price=resultSet.getDouble(6);
                String currency=resultSet.getString(7);
                System.out.println("id is:"+id1+"  product name:"+name+"  brand name :"+brand+"  model :"+model+"  price :"+price+"   currency:"+currency);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

    @Override
    public void findByIdModel(int id, String productModel) {
        ResultSet resultSet = ecommerceDao.findByIdModel(id, productModel);
        try {
            while (resultSet.next()) {
                System.out.println("Print all data");
                int id1=resultSet.getInt(1);
                String name=resultSet.getString(2);
                String brand=resultSet.getString(3);
                String model=resultSet.getString(4);
                double price=resultSet.getDouble(6);
                String currency=resultSet.getString(7);
                System.out.println("id is:"+id1+"  product name:"+name+"  brand name :"+brand+"  model :"+model+"  price :"+price+"   currency:"+currency);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void countByCurrency(String currency) {
        int row = ecommerceDao.countByCurrency(currency);
        System.out.println("the number of times it occurs is:"+row);

    }

    @Override
    public void productNameAndBrand(String productName, String productBrand) {
        ResultSet resultSet = ecommerceDao.productNameAndBrand(productName, productBrand);
        try {
            while (true) {
                resultSet.next();
                int id1=resultSet.getInt(1);
                String name=resultSet.getString(2);
                String brand=resultSet.getString(3);
                String model=resultSet.getString(4);
                Date date=resultSet.getDate(5);
                double price=resultSet.getDouble(6);
                String currency=resultSet.getString(7);
                System.out.println("id is:"+id1+"  product name:"+name+"  brand name :"+brand+"  model :"+model+"  price :"+price+"  date:"+date+"   currency:"+currency);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public boolean updatePriceById(int id, double price) {
        int num = ecommerceDao.updatePriceById(id, price);
        if (num>0){
            System.out.println("done updation");
            return true;
        }
        return false;
    }

    @Override
    public boolean updateBrandByid(int id, String productBrand) {
        int integer = ecommerceDao.updateBrandByid(id, productBrand);
        if (integer>0){
            System.out.println("done update");
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        int integer = ecommerceDao.deleteById(id);
        if (integer>0){
            System.out.println("done delete");
            return true;
        }
        return false;
    }
}
