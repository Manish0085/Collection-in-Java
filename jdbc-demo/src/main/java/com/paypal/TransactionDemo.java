package com.paypal;

import java.sql.*;

public class TransactionDemo {

    private static final String URL = "mysql:jdbc://localhost:3306/demo";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)){
            System.out.println("Connected to Database!!!");

            // Set Auto commit to false
            // TURNED OFF AUTO COMMIT == NO AUTO SAVE
            conn.setAutoCommit(false);

            try {
                // Order, OrderItems
                int orderId = insertOrder(conn, 101, "Alice01", 2000.0);

                // INSERT INTO ORDER ITEM
                insertOrderItem(conn, orderId, "Laptop01", 1, 2000.0);

                conn.commit();
                System.out.println("Transaction Committed Successfully!!!");
            } catch (Exception e) {
                e.printStackTrace();
                conn.rollback();
                System.out.println("Operation rollback successful");
            }
            finally {
                conn.setAutoCommit(true);
            }
        }catch (Exception e){
            System.out.println("Exception occurred while interacting with database...");
            System.out.println("Error: " + e.getMessage());
        } finally {

        }
    }

    private static void insertOrderItem(Connection conn, int orderId, String productName, int quantity, double price) {
        String sql = "INSERT INTO orderItems (orderId, product_name, quantity, price) VALUES (?, ?, ?, ?)";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, orderId);
            pstmt.setString(2, productName);
            pstmt.setInt(3, quantity);
            pstmt.setDouble(4, price);
            int rows = pstmt.executeUpdate();
            System.out.println("INSERTED into orderItems " + rows);

        }catch (Exception e){
            System.out.println("Exception occurred while interacting with database...");
            System.out.println("Error: " + e.getMessage());
        }
    }


    private static int insertOrder(Connection conn, int customerId, String customerName, double price) {
        String sql = "INSERT INTO orders (user_id, customer_name, total_amount) VALUES (?, ?, ?)";
        try(PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, customerId);
            pstmt.setString(2, customerName);
            pstmt.setDouble(3, price);
            int rows = pstmt.executeUpdate();
            System.out.println("INSERTED into orders " + rows);
            try (ResultSet resultSet = pstmt.getResultSet()){
                if (resultSet.next()){
                    int orderId = resultSet.getInt(1);
                    System.out.println("Generated Order Id: "+orderId);
                    return orderId;
                } else {
                    throw new SQLException("Order ID not generated");
                }
            }
        }catch (Exception e){
            System.out.println("Exception occurred while interacting with database...");
            System.out.println("Error: " + e.getMessage());
        }
        return 0;
    }


}
