package Registraator;

import java.sql.*;

/**
 * Created by kristjan on 13/12/15.
 */
public class Database {
    Connection conn = null;


    public Database() {
        createConnection();
        createTables();
    }


    private void createConnection(){
        try{
            Class.forName("org.sqlite.JDBC");
            conn =DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch (Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Database opened successfully");
    }

    public void createTables(){
        String sql = "CREATE TABLE IF NOT EXISTS VISITORS (ID INT AUTO_INCREMENT, FIRST_NAME TEXT, " +
                "FAMILY_NAME TEXT, N_ID INT, V_CARD INT);";
        makeChangeInDatabase(sql);
        sql = "CREATE TABLE IF NOT EXISTS HOSTS (ID INT AUTO_INCREMENT, FIRST_NAME TEXT, " +
                "FAMILY_NAME TEXT, LOCATION TEXT);";
        makeChangeInDatabase(sql);

    }

    private void makeChangeInDatabase(String sql) {
        try {
            Statement stat = conn.createStatement();
            stat.executeUpdate(sql);
            stat.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("success!!");
    }


}
