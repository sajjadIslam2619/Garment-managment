package dbGarmentHibernate.entity;

import java.io.Serializable;
import com.finalist.util.log.*;

import javax.persistence.*;
import dbGarmentHibernate.*;

/**
 * The OrderStatusType entity bean.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.23 $, $Date: 2006/05/19 20:42:48 $
 *
 *
 */
@Entity
@Table(name = "order_status_type")
public class OrderStatusType extends DbgarmentModelBase implements Serializable {

   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(OrderStatusType.class);



   private java.lang.Integer idOrderStatusType;
   private java.lang.String orderStatusName;

   /**
    * Default constructor.
    */
   public OrderStatusType() {
   }

   /**
    * Value object constructor.
    */
   public OrderStatusType(dbGarmentHibernate.entity.OrderStatusType value) {
      if (value != null) {
         setIdOrderStatusType(value.getIdOrderStatusType());
      }
      if (value != null) {
         setOrderStatusName(value.getOrderStatusName());
      }
   }

    /**
     * Return the primary key.
     *
     * @return java.lang.Integer with the primary key.
     */
   @javax.persistence.Transient
   public java.lang.Integer getPrimaryKey() {
        return getIdOrderStatusType();
    }

    /**
     * Set the primary key.
     *
     * @param primaryKey the primary key
     */
   @javax.persistence.Transient
   public void setPrimaryKey(java.lang.Integer primaryKey) {
       setIdOrderStatusType(primaryKey);
    }

   /**
    * Returns the value of the <code>idOrderStatusType</code> property.
    *
    */
   @Column(name = "id_order_status_type" , nullable = false )
//  For a more generic generator, chose AUTO.
   @Id @GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
   public java.lang.Integer getIdOrderStatusType() {
      return idOrderStatusType;
   }

   /**
    * Sets the value of the <code>idOrderStatusType</code> property.
    *
    * @param idOrderStatusType the value for the <code>idOrderStatusType</code> property
    */
   public void setIdOrderStatusType(java.lang.Integer idOrderStatusType) {
      this.idOrderStatusType = idOrderStatusType;
   }

   /**
    * Returns the value of the <code>orderStatusName</code> property.
    *
    */
   @Column(name = "order_status_name" , nullable = false , length=55 )
   public java.lang.String getOrderStatusName() {
      return orderStatusName;
   }

   /**
    * Sets the value of the <code>orderStatusName</code> property.
    *
    * @param orderStatusName the value for the <code>orderStatusName</code> property
    */
   public void setOrderStatusName(java.lang.String orderStatusName) {
      this.orderStatusName = orderStatusName;
   }




    /**
     * Used by the display tag library for rendering a checkbox in the list.
     * @return String with a HTML checkbox.
     */
    @Transient
    public String getCheckbox() {
        String checkBox = "<input type=\"checkbox\" name=\"checkbox";
        checkBox += "_"+ getIdOrderStatusType();
        checkBox += "\"/>";
        return checkBox;
    }


}
