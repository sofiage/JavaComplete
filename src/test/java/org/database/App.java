package org.database;

public class App {
    public static void main(String[] args){

        MyRepository myRepository = new MyRepository();

        myRepository.getAllOrders();

        System.out.println(myRepository.getAllOrders());

    }
}
