package org.database;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private int id;
    private Date date;
    private String address;
    private List<Product> productList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", address='" + address + '\'' +
                ", productList=" + productList +
                '}' + "\n";
    }
}
