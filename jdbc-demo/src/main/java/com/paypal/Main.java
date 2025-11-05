package com.paypal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

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
        String query = "insert into student(name, email) value ('" + name + "', '" + email + "')";
        try (Statement stmt = conn.createStatement()){
            int rows = stmt.executeUpdate(query);
            System.out.println("Data Inserted: " + rows);
        }catch (Exception e){
            System.out.println("Exception occurred while interacting with database...");
            System.out.println("Error: " + e.getMessage());
        }
    }


    public static void selectData(Connection conn){
        String query = "select * from student";
        try (Statement stmt = conn.createStatement()){
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                System.out.println(id + " | " + name + " | " + " | " + email);
            }
        }catch (Exception e){
            System.out.println("Exception occurred while interacting with database...");
            System.out.println("Error: " + e.getMessage());
        }
    }


    public static void updateData(Connection conn, int id, String name, String email){
        String query = "update student set name = " + name + ", email = " + email + " where id = " + id;
        try (Statement stmt = conn.createStatement()){
            int rows = stmt.executeUpdate(query);
            System.out.println("Data Updated: " + rows);
        }catch (Exception e){
            System.out.println("Exception occurred while interacting with database...");
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void deleteData(Connection conn, int id){
        String query = "delete from student where id = " + id;
        try (Statement stmt = conn.createStatement()){
            int rows = stmt.executeUpdate(query);
            System.out.println("Data Deleted: " + rows);
        }catch (Exception e){
            System.out.println("Exception occurred while interacting with database...");
            System.out.println("Error: " + e.getMessage());
        }
    }
}