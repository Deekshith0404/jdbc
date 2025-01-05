package com.xworkz.broke.runner;

import com.xworkz.broke.service.EcommerceService;
import com.xworkz.broke.service.EcommerceServiceImpl;

public class FindByModelRunner {
    private static EcommerceService ecommerceService = new EcommerceServiceImpl();

    public static void main(String[] args) {
        ecommerceService.findByIdModel(5, "cover");

    }
}
