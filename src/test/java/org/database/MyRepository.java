package org.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class MyRepository {
    private Connection connection;

    //Connect method to database
    public void connect() {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/mydatabase";
        String username = "postgres";
        String password = "Garmin23";


        //Register the PostgresSQL driver
        try {
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Order> getAllOrders() {

        List<Order> orderList = new ArrayList<>();

        try {
            connect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM public.orders_products op\n" +
                    "JOIN public.products p ON p.id = op.product_id\n" +
                    "JOIN public.orders o ON o.id = op.order_id\n" +
                    "ORDER BY o.address");


            while (resultSet.next()) {
                Order order;
                int id = resultSet.getInt("order_id");
                Optional<Order> orderOptional = orderList.stream()
                        .filter(o -> o.getId() == id)
                        .findAny();
                if (orderOptional.isPresent()) {
                    order = orderOptional.get();
                } else {
                    order = new Order();
                }


                Date date = resultSet.getDate("date");
                String address = resultSet.getString("address");
                order.setAddress(address);
                order.setDate(date);
                order.setId(id);
                orderList.add(order);
                Product product = new Product(resultSet.getInt("product_id"), resultSet.getString("name"), resultSet.getInt("quantity"));
                order.getProductList().add(product);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        closeConnection();
        return orderList;
    }
}


