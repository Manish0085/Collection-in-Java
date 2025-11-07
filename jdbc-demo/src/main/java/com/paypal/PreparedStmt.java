package com.paypal;

import java.sql.*;

public class PreparedStmt {

    private static final String URL = "mysql:jdbc://localhost:3306/demo";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)){

        }catch (Exception e){
            System.out.println("Exception occurred while interacting with database...");
            System.out.println("Error: " + e.getMessage());
        }
    }


    public static void insertData(Connection conn, String name, String email){
        String query = "INSERT INTO student(name, email) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, name);
            stmt.setString(2, email);
            int rows = stmt.executeUpdate();
            System.out.println("Data Inserted: " + rows);
        }catch (Exception e){
            System.out.println("Exception occurred while interacting with database...");
            System.out.println("Error: " + e.getMessage());
        }
    }


    public static void selectData(Connection conn){
        String query = "SELECT * FROM student";
        try (PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                System.out.println(id + " | " + name + " | " + email);
            }
        }catch (Exception e){
            System.out.println("Exception occurred while interacting with database...");
            System.out.println("Error: " + e.getMessage());
        }
    }


    public static void updateData(Connection conn, int id, String name, String email){
        String query = "UPDATE STUDENT SET name = ?, email = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setInt(3, id);
            int rows = stmt.executeUpdate();
            System.out.println("Data Updated: " + rows);
        }catch (Exception e){
            System.out.println("Exception occurred while interacting with database...");
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void deleteData(Connection conn, int id){
        String query = "DELETE FROM student WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1, 1);
            int rows = stmt.executeUpdate();
            System.out.println("Data Deleted: " + rows);
        }catch (Exception e){
            System.out.println("Exception occurred while interacting with database...");
            System.out.println("Error: " + e.getMessage());
        }
    }
}
