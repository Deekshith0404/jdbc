package com.xworks.service;

import com.xworks.dao.ThingsDao;
import com.xworks.dao.ThingsDaoImpl;

public class ThingsServiceImpl implements ThingsService{
    private ThingsDao thingsDao=new ThingsDaoImpl();

    @Override
    public boolean validationSave(String things, String brand, String color) {

        boolean isthings=true;
        boolean isbrand=true;
        boolean iscolor=true;

        if (things!=null && things.length()>3){
            System.out.println("things value is valid");
        }else {
            System.out.println("things is not valid");
            isthings=false;
        }

        if (brand!=null && things.length()>3){
            System.out.println("brand value is valid");
        }else {
            System.out.println("brand is not valid");
            isbrand=false;
        }

        if (color!=null){
            System.out.println("color value is valid");
        }else {
            System.out.println("color is invalid");
            iscolor=false;
        }

        if (isbrand==true && isthings==true && iscolor == true){
            int row=thingsDao.save(things,brand,color);
            System.out.println("number of row saved id :"+row);
            System.out.println("all the fields are valid");
            return true;
        }else {
            System.out.println("not all fielse are valid");
            return false;
        }


    }
}
