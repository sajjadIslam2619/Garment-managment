package dbGarmentHibernate.entity;

import java.io.Serializable;
import com.finalist.util.log.*;

import javax.persistence.*;
import dbGarmentHibernate.*;

/**
 * The OrderType entity bean.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.23 $, $Date: 2006/05/19 20:42:48 $
 *
 *
 */
@Entity
@Table(name = "order_type")
public class OrderType extends DbgarmentModelBase implements Serializable {

   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(OrderType.class);



   private java.lang.Integer idOrderType;
   private java.lang.String orderName;

   /**
    * Default constructor.
    */
   public OrderType() {
   }

   /**
    * Value object constructor.
    */
   public OrderType(dbGarmentHibernate.entity.OrderType value) {
      if (value != null) {
         setIdOrderType(value.getIdOrderType());
      }
      if (value != null) {
         setOrderName(value.getOrderName());
      }
   }

    /**
     * Return the primary key.
     *
     * @return java.lang.Integer with the primary key.
     */
   @javax.persistence.Transient
   public java.lang.Integer getPrimaryKey() {
        return getIdOrderType();
    }

    /**
     * Set the primary key.
     *
     * @param primaryKey the primary key
     */
   @javax.persistence.Transient
   public void setPrimaryKey(java.lang.Integer primaryKey) {
       setIdOrderType(primaryKey);
    }

   /**
    * Returns the value of the <code>idOrderType</code> property.
    *
    */
   @Column(name = "id_order_type" , nullable = false )
//  For a more generic generator, chose AUTO.
   @Id @GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
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
    * Returns the value of the <code>orderName</code> property.
    *
    */
   @Column(name = "order_name" , nullable = false , length=55 )
   public java.lang.String getOrderName() {
      return orderName;
   }

   /**
    * Sets the value of the <code>orderName</code> property.
    *
    * @param orderName the value for the <code>orderName</code> property
    */
   public void setOrderName(java.lang.String orderName) {
      this.orderName = orderName;
   }




    /**
     * Used by the display tag library for rendering a checkbox in the list.
     * @return String with a HTML checkbox.
     */
    @Transient
    public String getCheckbox() {
        String checkBox = "<input type=\"checkbox\" name=\"checkbox";
        checkBox += "_"+ getIdOrderType();
        checkBox += "\"/>";
        return checkBox;
    }


}
