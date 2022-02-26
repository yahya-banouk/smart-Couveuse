package com.example.jfxprjct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JavaConnection2DB {
    private static Connection conn ;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/couveuseDB" , "root","");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();}

    }

    public static Connection getConn() {
        return conn;
    }
};
/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JavaConnection2DB {
    private static String url = "jdbc:sqlserver://DESKTOP-UNKQJ81;databasename=gestionCouveuse";
    private static String user = "ya";
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
*/



