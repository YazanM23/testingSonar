package sakancom.loginFeature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;

public class Furniture {

String  picture;
String  description;
String price;
String  id;
String selled;
String queryS="Select * from forniture where username_tenant='";
    private static final Logger logger = Logger.getLogger(Furniture.class.getName());
    String host = "localhost";
    int port = 3306;
    String database = "sakancom";
    String username = "root";
    String password = "password";
    String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
public boolean checkAvailability(String userName){


    try (Connection connection = DriverManager.getConnection(url, username, password)) {
        Statement statement = connection.createStatement();

        String query  =queryS+userName+"' and Selled='No'";
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
return true;
        }

    }
    catch (Exception e){

    }
    return false;


}
public boolean displayFurniture(String userName){
if(checkAvailability(userName)){

    int counter = 1;
    try (Connection connection = DriverManager.getConnection(url, username, password)) {
        Statement statement = connection.createStatement();

        String query = queryS+userName+"'";
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            String idt="ID : "+resultSet.getString(5);
            logger.info(counter+"-");
            logger.info(idt);
            logger.info("Picture : "+resultSet.getString(2));
            logger.info("residence_location_desc : "+resultSet.getString(3));
            logger.info("Price : "+resultSet.getString(4));
            logger.info("_____________________________________________");
            counter++;
        }
        if(counter>1){
            return true;
        }

    }
    catch (Exception e){

    }

}
    return false;
}
public boolean  addFurniture(String userName,String picture,String description,String price,String id,String selled) {
    String query = "insert into forniture (id,picture,residence_location_desc,price,username_tenant,selled) value ('" + id + "','" + picture + "','" + description + "','" + price + "','" + userName + "','" + selled + "')";


    try (Connection connection = DriverManager.getConnection(url, username, password)) {
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        return true;
    }
    catch (Exception e){
        return false;

    }



}

public boolean sellFurniture(String id,String userName){
    if(checkAvailability(userName,id)) {


        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            String query = "update forniture set selled='Yes' where id='" + id + "'";
            statement.executeUpdate(query);

return true;
        } catch (Exception e) {

        }
    }


    return false;
}

    public boolean checkAvailability(String userName,String id){

        int counter = 1;
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();

           String query = queryS+userName+"' and selled='No' and id='"+id+"'";

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
          counter++;


            }
            if(counter>1){
                return true;
            }



        }
        catch (Exception e){

        }


        return false;


    }


}
