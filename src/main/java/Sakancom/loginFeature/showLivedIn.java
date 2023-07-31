package Sakancom.loginFeature;

import io.cucumber.java.an.E;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class showLivedIn {

    public boolean isLived(String id){
        String host = "localhost";
        int port = 3306;
        String database = "Sakancom";
        String username = "root";
        String password = "password";
        String url = "jdbc:mysql://" + host + ":" + port + "/" + database;

        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            Statement statement = connection.createStatement();
            String query = new String();
            query = "Select * from Tenants_Housing where houseID='" + id + "'";
            ResultSet res = statement.executeQuery(query);
            while (res.next()){
                return true;
            }

        }
        catch (Exception e){

        }

        return false;

    }
    public boolean displayLived(String id) {
        if (isLived(id)) {
            String host = "localhost";
            int port = 3306;
            String database = "Sakancom";
            String username = "root";
            String password = "password";
            String url = "jdbc:mysql://" + host + ":" + port + "/" + database;

            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                Statement statement = connection.createStatement();
                String query = new String();
                query = "Select * from Tenants_Housing where houseID='" + id + "'";
                ResultSet res = statement.executeQuery(query);
                while (res.next()) {
                    System.out.println("People is : " + res.getString(1));

                }
                return true;
            } catch (Exception e) {

            }


        }
        return false;
    }


}
