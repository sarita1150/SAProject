package project;

import javafx.scene.control.Button;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnection {
    private  static String driver = "com.mysql.jdbc.Driver";
    private static String dbURL ="jdbc:mysql://remotemysql.com:3306/SjPNg8sQV9";
    private static String dbUser = "SjPNg8sQV9";
    private static String dbPass = "EharkHnOgX";



    public void addData(){
        try {
            Class.forName(driver);
            java.sql.Connection conn = DriverManager.getConnection(dbURL,dbUser,dbPass);
            if (conn != null) {
                System.out.println("Connected to the database....");
                String query = "Insert Into Employee VALUES ()";
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                    System.out.println("pass = "+resultSet.getString("password"));
                    System.out.println("id = "+resultSet.getString("username"));
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean isLogin(String username,String password){
        try {
            Class.forName(driver);
            java.sql.Connection conn = DriverManager.getConnection(dbURL,dbUser,dbPass);
            if (conn != null) {
                System.out.println("Connected to the database....");
                String query = "Select username,password from Employee";
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()){
                    if(resultSet.getString("username").equals(username)
                            && resultSet.getString("password").equals(password)){
                        System.out.println("pass : "+resultSet.getString("password"));
                        System.out.println("id : "+resultSet.getString("username"));
                        return true;

                    }

                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public  static  ArrayList<OrderDetailController> showorderdetail() {
        ArrayList<OrderDetailController> orderDetailControllers = new ArrayList<>();
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(dbURL,dbUser,dbPass);
            String query = "Select order_id,order_status from Order";
            String query1 = "Select product_name from Product";
            String query2 = "Select quantity from Orderdetail";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            ResultSet resultSet1 = statement.executeQuery(query1);
            ResultSet resultSet2 = statement.executeQuery(query2);
            while (resultSet.next()) {
                orderDetailControllers.add(new OrderDetailController());
                System.out.println(resultSet.getString("order_id"));
                System.out.println(resultSet.getString("order_status"));
                System.out.println(resultSet1.getString("product_name"));
                System.out.println(resultSet2.getString("quantity"));
            }
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public static ArrayList<Product> showProduct(){
        ArrayList<Product> product = new ArrayList<>();
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(dbURL,dbUser,dbPass);
            String query = "Select * From Product;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                product.add(new Product(resultSet.getInt(1),resultSet.getString("product_name"),resultSet.getInt("quantity"),resultSet.getInt("price"),resultSet.getString("description"),resultSet.getString("lastupdate")));
                System.out.println(resultSet.getString("product_id"));
                System.out.println(resultSet.getString("product_name"));
            }
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("ok");
        return product;
    }

    public static void addProduct(int quantity,int product_id){
        try {
            Connection conn = DriverManager.getConnection(dbURL,dbUser,dbPass);
            if (conn != null) {
                System.out.println("Connected to the database....");
                String query = "Update Product Set quantity = quantity +"+ quantity + " Where product_id = "+product_id;
                Statement statement = conn.createStatement();
                statement.executeUpdate(query);
            }
        } catch (Exception ex){
            System.out.println("error");
        }
    }


    public static void decreaseProduct(Product product){
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(dbURL,dbUser,dbPass);
            String query = "Update Product Set quantity = quantity -"+ product.getQuantity() + " Where product_id = "+product.getProduct_id();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkPacked(int order_id){
        boolean check = false;
        try{
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(dbURL,dbUser,dbPass);
            String query = "Select order_status From Order Where order_id = "+order_id;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                if(resultSet.getString("status").equals("packed"))
                    check = true;
            }
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }
}

