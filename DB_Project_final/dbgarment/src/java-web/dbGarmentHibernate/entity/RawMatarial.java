package dbGarmentHibernate.entity;

import java.io.Serializable;
import com.finalist.util.log.*;

import javax.persistence.*;
import dbGarmentHibernate.*;

/**
 * The RawMatarial entity bean.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.23 $, $Date: 2006/05/19 20:42:48 $
 *
 *
 */
@Entity
@Table(name = "raw_matarial")
public class RawMatarial extends DbgarmentModelBase implements Serializable {

   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(RawMatarial.class);



   private java.lang.Integer idRawMatarial;
   private java.lang.Integer idRawMaterialType;
   private java.lang.Integer rawMaterialAmount;
   private java.lang.Double perUnitPrice;

   /**
    * Default constructor.
    */
   public RawMatarial() {
   }

   /**
    * Value object constructor.
    */
   public RawMatarial(dbGarmentHibernate.entity.RawMatarial value) {
      if (value != null) {
         setIdRawMatarial(value.getIdRawMatarial());
      }
      if (value != null) {
         setIdRawMaterialType(value.getIdRawMaterialType());
      }
      if (value != null) {
         setRawMaterialAmount(value.getRawMaterialAmount());
      }
      if (value != null) {
         setPerUnitPrice(value.getPerUnitPrice());
      }
   }

    /**
     * Return the primary key.
     *
     * @return java.lang.Integer with the primary key.
     */
   @javax.persistence.Transient
   public java.lang.Integer getPrimaryKey() {
        return getIdRawMatarial();
    }

    /**
     * Set the primary key.
     *
     * @param primaryKey the primary key
     */
   @javax.persistence.Transient
   public void setPrimaryKey(java.lang.Integer primaryKey) {
       setIdRawMatarial(primaryKey);
    }

   /**
    * Returns the value of the <code>idRawMatarial</code> property.
    *
    */
   @Column(name = "id_raw_matarial" , nullable = false )
//  For a more generic generator, chose AUTO.
   @Id @GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
   public java.lang.Integer getIdRawMatarial() {
      return idRawMatarial;
   }

   /**
    * Sets the value of the <code>idRawMatarial</code> property.
    *
    * @param idRawMatarial the value for the <code>idRawMatarial</code> property
    */
   public void setIdRawMatarial(java.lang.Integer idRawMatarial) {
      this.idRawMatarial = idRawMatarial;
   }

   /**
    * Returns the value of the <code>idRawMaterialType</code> property.
    *
    */
   @Column(name = "id_raw_material_type" , nullable = false )
   public java.lang.Integer getIdRawMaterialType() {
      return idRawMaterialType;
   }

   /**
    * Sets the value of the <code>idRawMaterialType</code> property.
    *
    * @param idRawMaterialType the value for the <code>idRawMaterialType</code> property
    */
   public void setIdRawMaterialType(java.lang.Integer idRawMaterialType) {
      this.idRawMaterialType = idRawMaterialType;
   }

   /**
    * Returns the value of the <code>rawMaterialAmount</code> property.
    *
    */
   @Column(name = "raw_material_amount" , nullable = false )
   public java.lang.Integer getRawMaterialAmount() {
      return rawMaterialAmount;
   }

   /**
    * Sets the value of the <code>rawMaterialAmount</code> property.
    *
    * @param rawMaterialAmount the value for the <code>rawMaterialAmount</code> property
    */
   public void setRawMaterialAmount(java.lang.Integer rawMaterialAmount) {
      this.rawMaterialAmount = rawMaterialAmount;
   }

   /**
    * Returns the value of the <code>perUnitPrice</code> property.
    *
    */
   @Column(name = "per_unit_price" , nullable = false )
   public java.lang.Double getPerUnitPrice() {
      return perUnitPrice;
   }

   /**
    * Sets the value of the <code>perUnitPrice</code> property.
    *
    * @param perUnitPrice the value for the <code>perUnitPrice</code> property
    */
   public void setPerUnitPrice(java.lang.Double perUnitPrice) {
      this.perUnitPrice = perUnitPrice;
   }




    /**
     * Used by the display tag library for rendering a checkbox in the list.
     * @return String with a HTML checkbox.
     */
    @Transient
    public String getCheckbox() {
        String checkBox = "<input type=\"checkbox\" name=\"checkbox";
        checkBox += "_"+ getIdRawMatarial();
        checkBox += "\"/>";
        return checkBox;
    }


}
