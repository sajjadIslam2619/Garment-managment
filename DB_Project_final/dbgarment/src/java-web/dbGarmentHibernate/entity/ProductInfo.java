package dbGarmentHibernate.entity;

import java.io.Serializable;
import com.finalist.util.log.*;

import javax.persistence.*;
import dbGarmentHibernate.*;

/**
 * The ProductInfo entity bean.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.23 $, $Date: 2006/05/19 20:42:48 $
 *
 *
 */
@Entity
@Table(name = "product_info")
public class ProductInfo extends DbgarmentModelBase implements Serializable {

   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(ProductInfo.class);



   private java.lang.Integer idProduct;
   private java.lang.String productName;
   private java.lang.Integer idProductType;
   private java.lang.Double productPrice;
   private java.lang.String productImage;

   /**
    * Default constructor.
    */
   public ProductInfo() {
   }

   /**
    * Value object constructor.
    */
   public ProductInfo(dbGarmentHibernate.entity.ProductInfo value) {
      if (value != null) {
         setIdProduct(value.getIdProduct());
      }
      if (value != null) {
         setProductName(value.getProductName());
      }
      if (value != null) {
         setIdProductType(value.getIdProductType());
      }
      if (value != null) {
         setProductPrice(value.getProductPrice());
      }
      if (value != null) {
         setProductImage(value.getProductImage());
      }
   }

    /**
     * Return the primary key.
     *
     * @return java.lang.Integer with the primary key.
     */
   @javax.persistence.Transient
   public java.lang.Integer getPrimaryKey() {
        return getIdProduct();
    }

    /**
     * Set the primary key.
     *
     * @param primaryKey the primary key
     */
   @javax.persistence.Transient
   public void setPrimaryKey(java.lang.Integer primaryKey) {
       setIdProduct(primaryKey);
    }

   /**
    * Returns the value of the <code>idProduct</code> property.
    *
    */
   @Column(name = "id_product" , nullable = false )
//  For a more generic generator, chose AUTO.
   @Id @GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
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
    * Returns the value of the <code>productName</code> property.
    *
    */
   @Column(name = "product_name" , nullable = false , length=55 )
   public java.lang.String getProductName() {
      return productName;
   }

   /**
    * Sets the value of the <code>productName</code> property.
    *
    * @param productName the value for the <code>productName</code> property
    */
   public void setProductName(java.lang.String productName) {
      this.productName = productName;
   }

   /**
    * Returns the value of the <code>idProductType</code> property.
    *
    */
   @Column(name = "id_product_type" , nullable = false )
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
    * Returns the value of the <code>productPrice</code> property.
    *
    */
   @Column(name = "product_price" , nullable = false )
   public java.lang.Double getProductPrice() {
      return productPrice;
   }

   /**
    * Sets the value of the <code>productPrice</code> property.
    *
    * @param productPrice the value for the <code>productPrice</code> property
    */
   public void setProductPrice(java.lang.Double productPrice) {
      this.productPrice = productPrice;
   }

   /**
    * Returns the value of the <code>productImage</code> property.
    *
    */
   @Column(name = "product_image"  , length=200 )
   public java.lang.String getProductImage() {
      return productImage;
   }

   /**
    * Sets the value of the <code>productImage</code> property.
    *
    * @param productImage the value for the <code>productImage</code> property
    */
   public void setProductImage(java.lang.String productImage) {
      this.productImage = productImage;
   }




    /**
     * Used by the display tag library for rendering a checkbox in the list.
     * @return String with a HTML checkbox.
     */
    @Transient
    public String getCheckbox() {
        String checkBox = "<input type=\"checkbox\" name=\"checkbox";
        checkBox += "_"+ getIdProduct();
        checkBox += "\"/>";
        return checkBox;
    }


}
