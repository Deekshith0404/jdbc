package com.xworkz.broke.runner;

import com.xworkz.broke.service.EcommerceService;
import com.xworkz.broke.service.EcommerceServiceImpl;

public class UpdateBrandByIdRunner {
    private static EcommerceService ecommerceService = new EcommerceServiceImpl();

    public static void main(String[] args) {
        boolean brand = ecommerceService.updateBrandByid(4, "as");
        if (brand) {
            System.out.println("brand updated successfully");
        } else {
            System.out.println("brand not updated ");

        }


    }
}
