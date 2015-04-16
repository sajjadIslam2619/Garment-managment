/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseproject.getInfo;

import databaseproject.item.OrderInfoItem;
import databaseproject.item.OrderStatusItem;
import databaseproject.item.ProductInfoItem;
import databaseproject.item.UserIdItem;
import databaseproject.item.connector.Connector;
import databaseproject.item.ProductTypeItem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Fahad_G4
 */
public class DataCollectorFromDB {
    
    Connector db_connector = new Connector();

    public DataCollectorFromDB() {
    }
    
    public ArrayList<UserIdItem> checkedLogin(String e_mail, String passString) {
        ArrayList<UserIdItem> userIdItems = new ArrayList<>();
        
        String Userloginquery = "SELECT * FROM `user_type` natural join user_info WHERE user_email='"+e_mail+"' and password='"+passString+"'";
        try {
            db_connector.resultName = db_connector.statement.executeQuery(Userloginquery);
            if(db_connector.resultName.next()){
                String UserToken[] = Constants.user_table_token;
                UserIdItem item  = new UserIdItem(Integer.parseInt(db_connector.resultName.getString(UserToken[0])), db_connector.resultName.getString(UserToken[1]), db_connector.resultName.getString(UserToken[2]), db_connector.resultName.getString(UserToken[3]), db_connector.resultName.getString(UserToken[4]), db_connector.resultName.getString(UserToken[5]),db_connector.resultName.getString(UserToken[6]),db_connector.resultName.getString(UserToken[7]));
                    
                userIdItems.add(item);
                
                
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return userIdItems;
    }
    
    public int insertSignUpDataIntoDB(UserIdItem userIdItem) {
        
        String UserDuplicationquery = "SELECT * FROM `user_info` WHERE user_email='"+userIdItem.getUser_email()+"' and password='"+userIdItem.getPassword()+"'";
        try {
            db_connector.resultName = db_connector.statement.executeQuery(UserDuplicationquery);
            if(db_connector.resultName.next()){               
                return Constants.Duplicate;
                
                
            }else{
                String insertrSignUpDataQuery = "INSERT INTO `db_garments`.`user_info` (`id_user`, `user_name`, `full_name`, `user_email`, `id_user_type`, `password`, `company_name`) VALUES (NULL, '"+userIdItem.getUser_name()+"', '"+userIdItem.getFull_name()+"', '"+userIdItem.getUser_email()+"', '2', '"+userIdItem.getPassword()+"', '"+userIdItem.getCompany_name()+"');";
                
                db_connector.statement.executeUpdate(insertrSignUpDataQuery);
                
                String Userloginquery = "SELECT * FROM `user_type` natural join user_info WHERE user_email='"+userIdItem.getUser_email()+"' and password='"+userIdItem.getPassword()+"'";
                
                db_connector.resultName = db_connector.statement.executeQuery(Userloginquery);
                if(db_connector.resultName.next()){                    
                    return Constants.SuccessfulFlag;
               }
                
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }                             
        return Constants.FailedFlag;
    }
    
    
    public ArrayList<ProductInfoItem> getProductInfo() {
        ArrayList<ProductInfoItem> productInfoItems = new ArrayList<ProductInfoItem>();
        
        String getTypeQuery = "SELECT * FROM `product_info` WHERE 1";
        try {
            db_connector.resultName = db_connector.statement.executeQuery(getTypeQuery);
            while(db_connector.resultName.next()){
                String product_info_token[] = Constants.product_info_token;
                    
                ProductInfoItem item = new ProductInfoItem(Integer.parseInt(db_connector.resultName.getString(product_info_token[0])), db_connector.resultName.getString(product_info_token[1]),Integer.parseInt(db_connector.resultName.getString(product_info_token[2])), Double.parseDouble(db_connector.resultName.getString(product_info_token[3])), db_connector.resultName.getString(product_info_token[4]));
                productInfoItems.add(item);
                //ResultSet resultName= db_connector.statement.executeQuery(getTypeQuery);
                
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return productInfoItems;
    }
    
    
    public ArrayList<OrderInfoItem> insertOrderData(ProductInfoItem productInfoItem, int amount,String estimatedDate,String order_detail) {
        ArrayList<OrderInfoItem> orderInfoItems = new ArrayList<OrderInfoItem>();
        String insertOrderStatusQuesry = "INSERT INTO `db_garments`.`order_status` (`id_order_status`, `id_order_status_type`) VALUES (NULL, '1')";
        
        String getLastIndexOfOrderStatus = "SELECT * FROM `order_status` ORDER BY `id_order_status` DESC LIMIT 1";
        try {
            db_connector.resultName = db_connector.statement.executeQuery(getLastIndexOfOrderStatus);
            if(db_connector.resultName.next()){
                String order_status_type[] = Constants.order_status_type;
                    
                OrderStatusItem item = new OrderStatusItem(Integer.parseInt(db_connector.resultName.getString(order_status_type[0])), Integer.parseInt(db_connector.resultName.getString(order_status_type[1])));
                                            //int id_order_info, int id_user, int id_order_type, int product_amount, String order_estimated_date, int id_product, String order_detail, int id_order_status) {
        
                OrderInfoItem oInfoItem = new OrderInfoItem(1, Constants.userIdItem.getId_user(), 2, amount, estimatedDate, productInfoItem.getId_product(),order_detail , 1);
                
                String insertOrderInfoQuesry = "INSERT INTO `db_garments`.`order_info` (`id_order_info`, `id_user`, `id_order_type`, `product_amount`, `order_estimated_date`, `id_product`, `order_detail`, `id_order_status`) VALUES (NULL, '"+oInfoItem.getId_user()+"', '"+oInfoItem.getId_order_type()+"', '"+oInfoItem.getProduct_amount()+"', '2014-04-22', '"+oInfoItem.getId_product()+"', '"+oInfoItem.getOrder_detail()+"', '"+oInfoItem.getId_order_status()+"')";
                
                db_connector.statement.executeUpdate(insertOrderInfoQuesry);
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        
        return orderInfoItems;
        
    }
    
    
    public ArrayList<OrderInfoItem> getOrderInfo(int id_order_type) {
        ArrayList<OrderInfoItem> orderInfoItems = new ArrayList<OrderInfoItem>();
        
        String getOrderQuery = "SELECT * FROM `order_info` WHERE id_order_type='"+id_order_type+"'";
        try {
            db_connector.resultName = db_connector.statement.executeQuery(getOrderQuery);
            while(db_connector.resultName.next()){
                String order_info_token[] = Constants.order_info_token;
                    
                OrderInfoItem item = new OrderInfoItem(Integer.parseInt(db_connector.resultName.getString(order_info_token[0])), Integer.parseInt(db_connector.resultName.getString(order_info_token[1])),Integer.parseInt(db_connector.resultName.getString(order_info_token[2])), Integer.parseInt(db_connector.resultName.getString(order_info_token[3])), db_connector.resultName.getString(order_info_token[4]),Integer.parseInt(db_connector.resultName.getString(order_info_token[5])), db_connector.resultName.getString(order_info_token[6]),Integer.parseInt(db_connector.resultName.getString(order_info_token[7])));
                orderInfoItems.add(item);
                //ResultSet resultName= db_connector.statement.executeQuery(getTypeQuery);
                
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return orderInfoItems;
    }
    
    public ArrayList<ProductInfoItem>  getProductInfoByProductIDInfo(int id_product) {
                
        ArrayList<ProductInfoItem> productInfoItems = new ArrayList<ProductInfoItem>();
        
        String getTypeQuery = "SELECT * FROM `product_info` WHERE id_product='"+id_product+"'";
        try {
            db_connector.resultName = db_connector.statement.executeQuery(getTypeQuery);
            while(db_connector.resultName.next()){
                String product_info_token[] = Constants.product_info_token;
                    
                ProductInfoItem item = new ProductInfoItem(Integer.parseInt(db_connector.resultName.getString(product_info_token[0])), db_connector.resultName.getString(product_info_token[1]),Integer.parseInt(db_connector.resultName.getString(product_info_token[2])), Double.parseDouble(db_connector.resultName.getString(product_info_token[3])), db_connector.resultName.getString(product_info_token[4]));
                productInfoItems.add(item);
                //ResultSet resultName= db_connector.statement.executeQuery(getTypeQuery);
                
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return productInfoItems;
    }
}
