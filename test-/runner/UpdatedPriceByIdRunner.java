package com.xworkz.broke.runner;

import com.xworkz.broke.service.EcommerceService;
import com.xworkz.broke.service.EcommerceServiceImpl;

public class UpdatedPriceByIdRunner {
    private static EcommerceService ecommerceService = new EcommerceServiceImpl();

    public static void main(String[] args) {
        boolean price = ecommerceService.updatePriceById(6, 9000);
        if (price) {
            System.out.println("Data is Updated");
        } else {
            System.out.println("Data is not updated");
        }

    }
}
