package dbGarmentHibernate.entity;

import java.io.Serializable;
import com.finalist.util.log.*;

import javax.persistence.*;
import dbGarmentHibernate.*;

/**
 * The ProductType entity bean.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.23 $, $Date: 2006/05/19 20:42:48 $
 *
 *
 */
@Entity
@Table(name = "product_type")
public class ProductType extends DbgarmentModelBase implements Serializable {

   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(ProductType.class);



   private java.lang.Integer idProductType;
   private java.lang.String productTypeName;

   /**
    * Default constructor.
    */
   public ProductType() {
   }

   /**
    * Value object constructor.
    */
   public ProductType(dbGarmentHibernate.entity.ProductType value) {
      if (value != null) {
         setIdProductType(value.getIdProductType());
      }
      if (value != null) {
         setProductTypeName(value.getProductTypeName());
      }
   }

    /**
     * Return the primary key.
     *
     * @return java.lang.Integer with the primary key.
     */
   @javax.persistence.Transient
   public java.lang.Integer getPrimaryKey() {
        return getIdProductType();
    }

    /**
     * Set the primary key.
     *
     * @param primaryKey the primary key
     */
   @javax.persistence.Transient
   public void setPrimaryKey(java.lang.Integer primaryKey) {
       setIdProductType(primaryKey);
    }

   /**
    * Returns the value of the <code>idProductType</code> property.
    *
    */
   @Column(name = "id_product_type" , nullable = false )
//  For a more generic generator, chose AUTO.
   @Id @GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
   public java.lang.Integer getIdProductType() {
      return idProductType;
   }

   /**
    * Sets the value of the <code>idProductType</code> property.
    *
    * @param idProductType the value for the <code>idProductType</code> property
    */
   public void setIdProductType(java.lang.Integer idProductType) {
      this.idProductType = idProductType;
   }

   /**
    * Returns the value of the <code>productTypeName</code> property.
    *
    */
   @Column(name = "product_type_name" , nullable = false , length=55 )
   public java.lang.String getProductTypeName() {
      return productTypeName;
   }

   /**
    * Sets the value of the <code>productTypeName</code> property.
    *
    * @param productTypeName the value for the <code>productTypeName</code> property
    */
   public void setProductTypeName(java.lang.String productTypeName) {
      this.productTypeName = productTypeName;
   }




    /**
     * Used by the display tag library for rendering a checkbox in the list.
     * @return String with a HTML checkbox.
     */
    @Transient
    public String getCheckbox() {
        String checkBox = "<input type=\"checkbox\" name=\"checkbox";
        checkBox += "_"+ getIdProductType();
        checkBox += "\"/>";
        return checkBox;
    }


}
