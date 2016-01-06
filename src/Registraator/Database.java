package Registraator;

import java.sql.*;
import java.util.HashMap;

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
            conn =DriverManager.getConnection("jdbc:sqlite:registrator.db");
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

    public void addHost(HashMap<String, String> data) {
        String firstName = data.get("firstName");
        String familyName = data.get("familyName");
        String sql = String.format("INSERT INTO HOSTS (FIRST_NAME, FAMILY_NAME) " +
                "VALUES ('%S', '%S')", firstName, familyName);
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

    //private void makeQuery

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("connection closed");
    }
}
