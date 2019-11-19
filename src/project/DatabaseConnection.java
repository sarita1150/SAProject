package project;

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

    public static ArrayList<Product> showProduct(){
        ArrayList<Product> product = new ArrayList<>();
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(dbURL,dbUser,dbPass);
            String query = "Select * From Product;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                product.add(new Product(resultSet.getInt("product_id"),resultSet.getString("product_name"),resultSet.getInt("quantity"),resultSet.getInt("price"),resultSet.getString("description"),resultSet.getString("lastupdate")));
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
        return product;
    }
//    public static boolean ModifiedStock(int id, int price, int weight) {
//        try {
//            Class.forName(driver);
//            Connection connection = DriverManager.getConnection(dbURL, dbUser, dbPass);
//            String query = "Update Product Set price = price + " + price + " Where product_id = " + id;
//            String query1 = "Update Product Set weight = weight + " + weight + " Where product_id = " + id;
//            Statement statement = connection.createStatement();
//            statement.executeUpdate(query);
//            statement.executeUpdate(query1);
//            connection.close();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//        public static boolean isAbleToBuy(int quantity){
//            try {
//                Class.forName(driver);
//                Connection connection = DriverManager.getConnection(dbURL,dbUser,dbPass);
//                String query = "Select quantity From Product Where quantity > 0";
//                Statement statement = connection.createStatement();
//                ResultSet resultSet = statement.executeQuery(query);
//                while (resultSet.next()) {
//                    if(resultSet.getInt(quantity) >= 0){
//                        return true;
//                    }
//                }
//                connection.close();
//            }
//            catch (SQLException e) {
//                e.printStackTrace();
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//
//        }
//        public static boolean checkPacked(int order_id){
//            boolean check = false;
//            try{
//                Class.forName(driver);
//                Connection connection = DriverManager.getConnection(dbURL,dbUser,dbPass);
//                String query = "Select order_status From Order Where order_id = "+order_id;
//                Statement statement = connection.createStatement();
//                ResultSet resultSet = statement.executeQuery(query);
//                while (resultSet.next()){
//                    if(resultSet.getString("status").equals("packed"))
//                        check = true;
//                }
//                connection.close();
//
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            return check;
//     }
}
