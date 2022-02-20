package com.example.jfxprjct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JavaConnection2DB {
    private static String url = "jdbc:sqlserver://DESKTOP-J6RLJ3K;databasename=mydatabase";
    private static String user = "sa";
    private static String password = "yahyabanouk99";
    private static Connection connection ;
    static {
        try {

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("great");

        } catch (SQLException e) {
            System.out.println("Ooops there's an error");
            e.printStackTrace();
        }
    }

    public static Connection getConn() {
        return connection;
    }
    public static void main(String[] args) throws SQLException {
        Connection co = getConn();
        co.close();




    }

};




