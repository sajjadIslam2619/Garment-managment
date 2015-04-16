/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseproject.item;

/**
 *
 * @author Fahad_G4
 */
public class ProductTypeItem {
    int id_product_type;
    String product_type_name;

    public ProductTypeItem(int id_product_type, String product_type_name) {
        this.id_product_type = id_product_type;
        this.product_type_name = product_type_name;
    }

    public int getId_product_type() {
        return id_product_type;
    }

    public void setId_product_type(int id_product_type) {
        this.id_product_type = id_product_type;
    }

    public String getProduct_type_name() {
        return product_type_name;
    }

    public void setProduct_type_name(String product_type_name) {
        this.product_type_name = product_type_name;
    }
    
    
}
