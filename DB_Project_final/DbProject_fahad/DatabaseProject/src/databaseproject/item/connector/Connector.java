
package databaseproject.item.connector;

import java.sql.*;
import javax.swing.JOptionPane;
import org.omg.CORBA.OBJECT_NOT_EXIST;


public class Connector
{

    

   String ServIPcon;
   static String database_URL2;
    public Connection con;
    public Statement statement;
    public ResultSet resultName;
    public ResultSetMetaData resultSetMetaData;
    static final String database_URL = "jdbc:mysql://localhost/db_garment";
    //static final String database_URL = "jdbc:mysql://192.168.2.106/backenddata";
   
    
    static final String USER_NAME = "root";
    static final String PASSWORD = "";

    
    public Connector() 
    {
        //database code////////////////////////////////////////////////////
        try {
                con = null;
                statement = null;
                resultName = null;
                resultSetMetaData = null;

            Class.forName("com.mysql.jdbc.Driver");
            //System.out.println("Connecting to Database....");

            con = DriverManager.getConnection(database_URL, USER_NAME, PASSWORD);

            statement = con.createStatement();
            
           //System.out.println("Connected");





        } catch (Exception e) {
            e.printStackTrace();


        }
     }
  
}
    

