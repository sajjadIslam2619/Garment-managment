/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseproject.item;


public class OrderInfoItem {
    int id_order_info, id_user,id_order_type, product_amount;
    String order_estimated_date;
    int id_product;
    String order_detail;
    int id_order_status;

    public OrderInfoItem(int id_order_info, int id_user, int id_order_type, int product_amount, String order_estimated_date, int id_product, String order_detail, int id_order_status) {
        this.id_order_info = id_order_info;
        this.id_user = id_user;
        this.id_order_type = id_order_type;
        this.product_amount = product_amount;
        this.order_estimated_date = order_estimated_date;
        this.id_product = id_product;
        this.order_detail = order_detail;
        this.id_order_status = id_order_status;
    }

    public int getId_order_info() {
        return id_order_info;
    }

    public void setId_order_info(int id_order_info) {
        this.id_order_info = id_order_info;
    }

    public int getId_order_status() {
        return id_order_status;
    }

    public void setId_order_status(int id_order_status) {
        this.id_order_status = id_order_status;
    }

    public int getId_order_type() {
        return id_order_type;
    }

    public void setId_order_type(int id_order_type) {
        this.id_order_type = id_order_type;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getOrder_detail() {
        return order_detail;
    }

    public void setOrder_detail(String order_detail) {
        this.order_detail = order_detail;
    }

    public String getOrder_estimated_date() {
        return order_estimated_date;
    }

    public void setOrder_estimated_date(String order_estimated_date) {
        this.order_estimated_date = order_estimated_date;
    }

    public int getProduct_amount() {
        return product_amount;
    }

    public void setProduct_amount(int product_amount) {
        this.product_amount = product_amount;
    }
    
    
}
