package dbGarmentHibernate.entity;

import java.io.Serializable;
import com.finalist.util.log.*;

import javax.persistence.*;
import dbGarmentHibernate.*;

/**
 * The OrderStatus entity bean.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.23 $, $Date: 2006/05/19 20:42:48 $
 *
 *
 */
@Entity
@Table(name = "order_status")
public class OrderStatus extends DbgarmentModelBase implements Serializable {

   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(OrderStatus.class);



   private java.lang.Integer idOrderStatus;
   private java.lang.Integer idOrderStatusType;

   /**
    * Default constructor.
    */
   public OrderStatus() {
   }

   /**
    * Value object constructor.
    */
   public OrderStatus(dbGarmentHibernate.entity.OrderStatus value) {
      if (value != null) {
         setIdOrderStatus(value.getIdOrderStatus());
      }
      if (value != null) {
         setIdOrderStatusType(value.getIdOrderStatusType());
      }
   }

    /**
     * Return the primary key.
     *
     * @return java.lang.Integer with the primary key.
     */
   @javax.persistence.Transient
   public java.lang.Integer getPrimaryKey() {
        return getIdOrderStatus();
    }

    /**
     * Set the primary key.
     *
     * @param primaryKey the primary key
     */
   @javax.persistence.Transient
   public void setPrimaryKey(java.lang.Integer primaryKey) {
       setIdOrderStatus(primaryKey);
    }

   /**
    * Returns the value of the <code>idOrderStatus</code> property.
    *
    */
   @Column(name = "id_order_status" , nullable = false )
//  For a more generic generator, chose AUTO.
   @Id @GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
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
    * Returns the value of the <code>idOrderStatusType</code> property.
    *
    */
   @Column(name = "id_order_status_type" , nullable = false )
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
     * Used by the display tag library for rendering a checkbox in the list.
     * @return String with a HTML checkbox.
     */
    @Transient
    public String getCheckbox() {
        String checkBox = "<input type=\"checkbox\" name=\"checkbox";
        checkBox += "_"+ getIdOrderStatus();
        checkBox += "\"/>";
        return checkBox;
    }


}
