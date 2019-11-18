package project;

import java.sql.*;

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
                    System.out.println(resultSet.getString("password"));
                    System.out.println(resultSet.getString("username"));
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
                        System.out.println(resultSet.getString("password"));
                        System.out.println(resultSet.getString("username"));
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



}