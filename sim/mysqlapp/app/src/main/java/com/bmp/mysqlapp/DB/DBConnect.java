package com.bmp.mysqlapp.DB;
import java.sql.*;
public class DBConnect {
    public static Connection getConnect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://217.21.87.231/u830503425_ecogrowthlao";
            String user="u830503425_jacksainther";
            String pwd="*Ac$HMBj01";
            Connection c =DriverManager.getConnection(url,user,pwd);
            return c;
        }catch ( Exception ex){
            return null;
        }

    }

}
