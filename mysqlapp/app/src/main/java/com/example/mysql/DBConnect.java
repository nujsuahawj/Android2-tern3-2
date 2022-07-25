package com.example.mysql;
import java.sql.*;
public class DBConnect {
    public static Connection getConnect(){
       try {
           Class.forName("com.mysql.jdbc.Driver");
           Connection con =DriverManager.getConnection("jdbc:mysql://192.168.35.1:8000/nodejscrud","root","mysql");
        return con;
       } catch (Exception ex) {
           return null;
       }
    }
}
