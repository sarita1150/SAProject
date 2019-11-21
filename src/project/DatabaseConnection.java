package project;

import com.sun.org.apache.bcel.internal.generic.Select;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnection {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String dbURL = "jdbc:mysql://remotemysql.com:3306/SjPNg8sQV9";
    private static String dbUser = "SjPNg8sQV9";
    private static String dbPass = "EharkHnOgX";


    public void addData() {
        try {
            Class.forName(driver);
            java.sql.Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
            if (conn != null) {
                System.out.println("Connected to the database....");
                String query = "Insert Into Employee VALUES ()";
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    System.out.println("pass = " + resultSet.getString("password"));
                    System.out.println("id = " + resultSet.getString("username"));
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean isLogin(String username, String password) {
        try {
            Class.forName(driver);
            java.sql.Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
            if (conn != null) {
                System.out.println("Connected to the database....");
                String query = "Select username,password from Employee";
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    if (resultSet.getString("username").equals(username)
                            && resultSet.getString("password").equals(password)) {
                        System.out.println("pass : " + resultSet.getString("password"));
                        System.out.println("id : " + resultSet.getString("username"));
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

    public static ArrayList<Order> showorderdetail() {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(dbURL, dbUser, dbPass);
            String query = "SELECT Orderdetail.order_id,MainOrder.order_status,Product.product_name,Customer.customer_name,Orderdetail.quantity FROM MainOrder INNER JOIN Orderdetail ON MainOrder.order_id = Orderdetail.order_id INNER JOIN Customer ON Customer.customer_id = MainOrder.customer_id INNER JOIN Product ON Product.product_id = MainOrder.product_id";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                orders.add(new Order(resultSet.getInt("order_id"), resultSet.getString("customer_name"), resultSet.getString("product_name"), resultSet.getString("order_status"), resultSet.getInt("quantity")));
                System.out.println(resultSet.getInt("order_id"));
                System.out.println(resultSet.getString("order_status"));
            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }

        System.out.println("ok");
        return orders;
    }

    public static ArrayList<Product> showProduct() {
        ArrayList<Product> product = new ArrayList<>();
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(dbURL, dbUser, dbPass);
            String query = "Select * From Product";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                product.add(new Product(resultSet.getInt("product_id"), resultSet.getString("product_name"), resultSet.getInt("quantity"), resultSet.getInt("price"), resultSet.getString("description")));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return product;
    }

    public static void addProduct(int quantity, int product_id) {
        try {
            Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
            if (conn != null) {
                System.out.println("Connected to the database....");
                String query = "Update Product Set quantity = quantity +" + quantity + " Where product_id = " + product_id;
                Statement statement = conn.createStatement();
                statement.executeUpdate(query);
            }
        } catch (Exception ex) {
            System.out.println("error");
        }
    }


    public static void decreaseProduct(int quantity, int product_id) {
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(dbURL, dbUser, dbPass);
            String query = "Update Product Set quantity = quantity -" + quantity + " Where product_id = " + product_id;
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void editStatus(String status, int id) {
        try {
            Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
            if (conn != null) {
                System.out.println("Connected to the database....");
                String query = "Update MainOrder Set order_status = '" + status + "' Where product_id = " + id;

                Statement statement = conn.createStatement();
                statement.executeUpdate(query);
                System.out.println("okok");
            }
        } catch (Exception ex) {
            System.out.println("error");
        }
    }

    public static ArrayList<Customer> showCustomer() {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(dbURL, dbUser, dbPass);
            String query = "Select * From Customer";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                customers.add(new Customer(resultSet.getInt("customer_id"), resultSet.getString("customer_name"), resultSet.getString("email"), resultSet.getString("tel"), resultSet.getString("address"), resultSet.getString("type")));
                System.out.println(resultSet.getInt("customer_id"));
                System.out.println(resultSet.getString("customer_name"));
            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }

        System.out.println("ok!");
        return customers;
    }

    public static void shopUpdate(ArrayList<Integer> quantity){
        try{
            Connection connection = DriverManager.getConnection(dbURL,dbUser,dbPass);
            Statement statement = connection.createStatement();
            for (int i = 1 ; i <= quantity.size() ; i ++){
                String query = "Update Product Set quantity = "+ quantity.get(i-1) +" Where product_id = "+i;
                statement.executeUpdate(query);
            }
            statement.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}


