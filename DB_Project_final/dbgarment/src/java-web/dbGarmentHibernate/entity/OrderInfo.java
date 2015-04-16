package dbGarmentHibernate.entity;

import java.io.Serializable;
import com.finalist.util.log.*;

import javax.persistence.*;
import dbGarmentHibernate.*;

/**
 * The OrderInfo entity bean.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.23 $, $Date: 2006/05/19 20:42:48 $
 *
 *
 */
@Entity
@Table(name = "order_info")
public class OrderInfo extends DbgarmentModelBase implements Serializable {

   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(OrderInfo.class);



   private java.lang.Integer idOrderInfo;
   private java.lang.Integer idUser;
   private java.lang.Integer idOrderType;
   private java.lang.Integer productAmount;
   private java.sql.Date orderEstimatedDate;
   private java.lang.Integer idProduct;
   private java.lang.String orderDetail;
   private java.lang.Integer idOrderStatus;

   /**
    * Default constructor.
    */
   public OrderInfo() {
   }

   /**
    * Value object constructor.
    */
   public OrderInfo(dbGarmentHibernate.entity.OrderInfo value) {
      if (value != null) {
         setIdOrderInfo(value.getIdOrderInfo());
      }
      if (value != null) {
         setIdUser(value.getIdUser());
      }
      if (value != null) {
         setIdOrderType(value.getIdOrderType());
      }
      if (value != null) {
         setProductAmount(value.getProductAmount());
      }
      if (value != null) {
         setOrderEstimatedDate(value.getOrderEstimatedDate());
      }
      if (value != null) {
         setIdProduct(value.getIdProduct());
      }
      if (value != null) {
         setOrderDetail(value.getOrderDetail());
      }
      if (value != null) {
         setIdOrderStatus(value.getIdOrderStatus());
      }
   }

    /**
     * Return the primary key.
     *
     * @return java.lang.Integer with the primary key.
     */
   @javax.persistence.Transient
   public java.lang.Integer getPrimaryKey() {
        return getIdOrderInfo();
    }

    /**
     * Set the primary key.
     *
     * @param primaryKey the primary key
     */
   @javax.persistence.Transient
   public void setPrimaryKey(java.lang.Integer primaryKey) {
       setIdOrderInfo(primaryKey);
    }

   /**
    * Returns the value of the <code>idOrderInfo</code> property.
    *
    */
   @Column(name = "id_order_info" , nullable = false )
//  For a more generic generator, chose AUTO.
   @Id @GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
   public java.lang.Integer getIdOrderInfo() {
      return idOrderInfo;
   }

   /**
    * Sets the value of the <code>idOrderInfo</code> property.
    *
    * @param idOrderInfo the value for the <code>idOrderInfo</code> property
    */
   public void setIdOrderInfo(java.lang.Integer idOrderInfo) {
      this.idOrderInfo = idOrderInfo;
   }

   /**
    * Returns the value of the <code>idUser</code> property.
    *
    */
   @Column(name = "id_user" , nullable = false )
   public java.lang.Integer getIdUser() {
      return idUser;
   }

   /**
    * Sets the value of the <code>idUser</code> property.
    *
    * @param idUser the value for the <code>idUser</code> property
    */
   public void setIdUser(java.lang.Integer idUser) {
      this.idUser = idUser;
   }

   /**
    * Returns the value of the <code>idOrderType</code> property.
    *
    */
   @Column(name = "id_order_type" , nullable = false )
   public java.lang.Integer getIdOrderType() {
      return idOrderType;
   }

   /**
    * Sets the value of the <code>idOrderType</code> property.
    *
    * @param idOrderType the value for the <code>idOrderType</code> property
    */
   public void setIdOrderType(java.lang.Integer idOrderType) {
      this.idOrderType = idOrderType;
   }

   /**
    * Returns the value of the <code>productAmount</code> property.
    *
    */
   @Column(name = "product_amount" , nullable = false )
   public java.lang.Integer getProductAmount() {
      return productAmount;
   }

   /**
    * Sets the value of the <code>productAmount</code> property.
    *
    * @param productAmount the value for the <code>productAmount</code> property
    */
   public void setProductAmount(java.lang.Integer productAmount) {
      this.productAmount = productAmount;
   }

   /**
    * Returns the value of the <code>orderEstimatedDate</code> property.
    *
    */
   @Column(name = "order_estimated_date" , nullable = false )
   public java.sql.Date getOrderEstimatedDate() {
      return orderEstimatedDate;
   }

   /**
    * Sets the value of the <code>orderEstimatedDate</code> property.
    *
    * @param orderEstimatedDate the value for the <code>orderEstimatedDate</code> property
    */
   public void setOrderEstimatedDate(java.sql.Date orderEstimatedDate) {
      this.orderEstimatedDate = orderEstimatedDate;
   }

   /**
    * Returns the value of the <code>idProduct</code> property.
    *
    */
   @Column(name = "id_product" , nullable = false )
   public java.lang.Integer getIdProduct() {
      return idProduct;
   }

   /**
    * Sets the value of the <code>idProduct</code> property.
    *
    * @param idProduct the value for the <code>idProduct</code> property
    */
   public void setIdProduct(java.lang.Integer idProduct) {
      this.idProduct = idProduct;
   }

   /**
    * Returns the value of the <code>orderDetail</code> property.
    *
    */
   @Column(name = "order_detail"  , length=500 )
   public java.lang.String getOrderDetail() {
      return orderDetail;
   }

   /**
    * Sets the value of the <code>orderDetail</code> property.
    *
    * @param orderDetail the value for the <code>orderDetail</code> property
    */
   public void setOrderDetail(java.lang.String orderDetail) {
      this.orderDetail = orderDetail;
   }

   /**
    * Returns the value of the <code>idOrderStatus</code> property.
    *
    */
   @Column(name = "id_order_status" , nullable = false )
   public java.lang.Integer getIdOrderStatus() {
      return idOrderStatus;
   }

   /**
    * Sets the value of the <code>idOrderStatus</code> property.
    *
    * @param idOrderStatus the value for the <code>idOrderStatus</code> property
    */
   public void setIdOrderStatus(java.lang.Integer idOrderStatus) {
      this.idOrderStatus = idOrderStatus;
   }




    /**
     * Used by the display tag library for rendering a checkbox in the list.
     * @return String with a HTML checkbox.
     */
    @Transient
    public String getCheckbox() {
        String checkBox = "<input type=\"checkbox\" name=\"checkbox";
        checkBox += "_"+ getIdOrderInfo();
        checkBox += "\"/>";
        return checkBox;
    }


}
