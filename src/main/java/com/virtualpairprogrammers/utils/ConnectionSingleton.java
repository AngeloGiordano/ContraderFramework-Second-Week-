package com.virtualpairprogrammers.utils;

//import main.controller.GestoreEccezioni;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.util.Properties;


public class ConnectionSingleton {


    private static Connection connection = null;


    private ConnectionSingleton() {
    }


    public static Connection getInstance() {
        if (connection == null) {
            try {
               Properties properties = new Properties();
                /*InputStream inputStream = new FileInputStream("config.properties");
                properties.load(inputStream);*/

                String vendor="mysql";
                String driver="com.mysql.jdbc.Driver";
                String host="127.0.0.1";
                String port="3306";
                String dbName="contrader";
                String username="root";
                String password ="root";
                /*String vendor = properties.getProperty("db.vendor");
                String driver = properties.getProperty("db.driver");
                String host = properties.getProperty("db.host");
                String port = properties.getProperty("db.port");
                String dbName = properties.getProperty("db.name");
                String username = properties.getProperty("db.username");
                String password = properties.getProperty("db.password");*/
                Class c = Class.forName(driver);
                System.out.println("Ho caricato: " + c.getName());
                String myUrl = "jdbc:" + vendor + "://" + host + ":" + port + "/" + dbName;
                DriverManagerDataSource dataSource = new DriverManagerDataSource(myUrl, username, password);
                dataSource.setDriverClassName(driver);
                connection = dataSource.getConnection();
            } catch (Exception e) {
                //GestoreEccezioni.getInstance().gestisciEccezione(e);
                e.printStackTrace();
            }
        }
        return connection;
    }

}
