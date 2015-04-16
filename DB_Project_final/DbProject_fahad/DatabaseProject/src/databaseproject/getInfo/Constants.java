package databaseproject.getInfo;

import databaseproject.item.UserIdItem;

public class Constants {

    public static int LOGIN_VIEW = 1;
    public static int SINGUP_VIEW = 2;
    public static int Byer_order_history_VIEW = 3;
    public static String user_table_token[] = {
        "id_user",
        "user_name", "full_name", "user_email", "password",
        "company_name","id_user_type","user_type_name"};
    public static String product_type_token[] = {"id_product_type","product_type_name"};
    public static String order_status_type[] = {"id_order_status","id_order_status_type"};
    public static String product_info_token[] = {"id_product","product_name","id_product_type","product_price","product_image"};
    public static String order_info_token[] ={"id_order_info","id_user","id_order_type","product_amount","order_estimated_date","id_product","order_detail","id_order_status"};
    
    public static int SuccessfulFlag = 1;
    public static int FailedFlag = 0;
    public static int Duplicate = 2;
    public static int user_id = 10;
    public static int Running = 1;
    public static int Pending = 2;
    public static int Finishing = 3;
    
    public static String Owner = "Owner";
    public static String Byer = "Byer";
    public static UserIdItem userIdItem=null;
    
    public static int runningOrder=1;
    public static int pendingOrder=2;
    public static int finishedOrder=3;
    
}
