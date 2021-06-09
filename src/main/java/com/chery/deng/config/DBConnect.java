package com.chery.deng.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private static Connection conn;
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/roomdb?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8&useSSL=false","root","123456");
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}
/**
 * 备用数据库连接操作
 */
