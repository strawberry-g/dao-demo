package com.cheer.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

//作用1：为外界提供获取数据库连接服务
//作用2：为外界提供关闭数据库资源服务
public class DbUtils {
    private static final DbUtils INSTANCE = new DbUtils();

    public DbUtils(){

    }

    public static DbUtils getInstance(){
        return INSTANCE;
    }

    /**
     * 获取数据库连接
     * @return
     */
    public Connection getConnection(){
        Properties properties = loadResource();
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        String driverClass = properties.getProperty("driverClass");
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    private Properties loadResource() {
        InputStream in = DbUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }

    /**
     * 关闭资源
     * @param connection
     * @param statement
     * @param resultSet
     */
    public void close(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
