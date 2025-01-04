package com.xworks.examples.runner;


import com.xworks.examples.dao.ShoppingDao;
import com.xworks.examples.daoImpl.ShoppingDaoImpl;

public class shoppingRunner {
    private static ShoppingDao shoppingDao=new ShoppingDaoImpl();
    private static  boolean isEmpty=true;

    public static void main(String[] args) {
        shoppingDao.save(0,"books shop","anu","bangalore","books",500);
        shoppingDao.getDataById(2);
//        int resultSet = shoppingDao.UpdatebyField(1, "vegetable shop", "kona", "chellur", "tomato", 300);
//        System.out.println(resultSet  + " :updated");
    }

}