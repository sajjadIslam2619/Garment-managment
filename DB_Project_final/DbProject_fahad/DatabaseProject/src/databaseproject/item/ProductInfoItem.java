/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseproject.item;


public class ProductInfoItem {
    int id_product;
    String product_name;
    int id_product_type;
    double product_price;
    String product_image;

    public ProductInfoItem(int id_product, String product_name, int id_product_type, double product_price, String product_image) {
        this.id_product = id_product;
        this.product_name = product_name;
        this.id_product_type = id_product_type;
        this.product_price = product_price;
        this.product_image = product_image;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public int getId_product_type() {
        return id_product_type;
    }

    public void setId_product_type(int id_product_type) {
        this.id_product_type = id_product_type;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }
    
    
}
