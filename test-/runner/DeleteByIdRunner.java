package com.xworkz.broke.runner;

import com.xworkz.broke.service.EcommerceService;
import com.xworkz.broke.service.EcommerceServiceImpl;

public class DeleteByIdRunner {
    private static EcommerceService ecommerceService = new EcommerceServiceImpl();

    public static void main(String[] args) {
        boolean deleteById = ecommerceService.deleteById(4);
        System.out.println("print if it is response true data is deleted otherwise data is not deleted ");
    }
}
