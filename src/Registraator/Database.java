package Registraator;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;

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
        String sql = "CREATE TABLE IF NOT EXISTS VISITORS (ID INT AUTO_INCREMENT, FIRSTNAME TEXT, " +
                "FAMILYNAME TEXT, VCARD TEXT, HOST TEXT);";
        makeChangeInDatabase(sql);
        sql = "CREATE TABLE IF NOT EXISTS HOSTS (ID INT AUTO_INCREMENT, FIRSTNAME TEXT, " +
                "FAMILYNAME TEXT, LOCATION TEXT);";
        makeChangeInDatabase(sql);

    }

    public void addHost(HashMap<String, String> data) {
        String firstName = data.get("firstName");
        String familyName = data.get("familyName");
        if (hostExists(firstName, familyName)){
            System.out.println("User already exists");
            return;
        }
        String sql = String.format("INSERT INTO HOSTS (FIRSTNAME, FAMILYNAME) " +
                "VALUES ('%S', '%S')", firstName, familyName);
        System.out.println(sql);
        makeChangeInDatabase(sql);
    }

    public void addVisitor(HashMap<String, String> data) {
        String firstName = data.get("firstName");
        String familyName = data.get("familyName");
        String cardNumber = data.get("cardNumber");
        String hostToVisit = data.get("hostToVisit");

        String sql = String.format("INSERT INTO VISITORS (FIRSTNAME, FAMILYNAME, VCARD, HOST) " +
                "VALUES ('%S', '%S', '%s', '%s')", firstName, familyName, cardNumber, hostToVisit);
        System.out.println(sql);
        makeChangeInDatabase(sql);

    }

    private boolean hostExists(String firstName, String familyName) {
        String sql = String.format("SELECT * FROM HOSTS WHERE " +
                "FIRSTNAME = '%s' AND FAMILYNAME = '%s'", firstName, familyName);
        try {
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            String test = rs.getString("firstname");

            rs.close();
            stat.close();
            return firstName.equals(test);

        } catch (SQLException e) {
            return false;

        }

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


    public ArrayList getHosts() {
        //ArrayList data = new ArrayList();
        //ArrayList lineOfData = new ArrayList();
        ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();

        String sql = "SELECT * FROM HOSTS";

        try {
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                int i = 0;
                HashMap<String, String> lineOfData = new HashMap<String, String>();
                lineOfData.put("firstName", rs.getString("firstname"));
                lineOfData.put("familyName", rs.getString("familyname"));

                data.add(lineOfData);

            }
            //System.out.println(data.toString());

            rs.close();
            stat.close();
            return data;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;

    }


    public ArrayList getVisitors() {
        ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
        String sql = "SELECT * FROM VISITORS";

        try {
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                int i = 0;
                HashMap<String, String> lineOfData = new HashMap<String, String>();
                lineOfData.put("firstName", rs.getString("firstname"));
                lineOfData.put("familyName", rs.getString("familyname"));
                lineOfData.put("cardNumber", rs.getString("vcard"));
                lineOfData.put("hostToVisit", rs.getString("host"));

                data.add(lineOfData);

            }
            //System.out.println(data.toString());

            rs.close();
            stat.close();
            return data;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;



    }
}
