/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseproject.item;

/**
 *
 * @author Fahad_G4
 */
public class OrderStatusItem {
    int id_order_status;
    int id_order_status_type;

    public OrderStatusItem(int id_order_status, int id_order_status_type) {
        this.id_order_status = id_order_status;
        this.id_order_status_type = id_order_status_type;
    }

    public int getId_order_status() {
        return id_order_status;
    }

    public void setId_order_status(int id_order_status) {
        this.id_order_status = id_order_status;
    }

    public int getId_order_status_type() {
        return id_order_status_type;
    }

    public void setId_order_status_type(int id_order_status_type) {
        this.id_order_status_type = id_order_status_type;
    }
    
    
}
