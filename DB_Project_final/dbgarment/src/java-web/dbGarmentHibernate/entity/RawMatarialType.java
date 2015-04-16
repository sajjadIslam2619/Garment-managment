package dbGarmentHibernate.entity;

import java.io.Serializable;
import com.finalist.util.log.*;

import javax.persistence.*;
import dbGarmentHibernate.*;

/**
 * The RawMatarialType entity bean.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.23 $, $Date: 2006/05/19 20:42:48 $
 *
 *
 */
@Entity
@Table(name = "raw_matarial_type")
public class RawMatarialType extends DbgarmentModelBase implements Serializable {

   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(RawMatarialType.class);



   private java.lang.Integer idRawMaterialType;
   private java.lang.String rawMaterialTypeName;

   /**
    * Default constructor.
    */
   public RawMatarialType() {
   }

   /**
    * Value object constructor.
    */
   public RawMatarialType(dbGarmentHibernate.entity.RawMatarialType value) {
      if (value != null) {
         setIdRawMaterialType(value.getIdRawMaterialType());
      }
      if (value != null) {
         setRawMaterialTypeName(value.getRawMaterialTypeName());
      }
   }

    /**
     * Return the primary key.
     *
     * @return java.lang.Integer with the primary key.
     */
   @javax.persistence.Transient
   public java.lang.Integer getPrimaryKey() {
        return getIdRawMaterialType();
    }

    /**
     * Set the primary key.
     *
     * @param primaryKey the primary key
     */
   @javax.persistence.Transient
   public void setPrimaryKey(java.lang.Integer primaryKey) {
       setIdRawMaterialType(primaryKey);
    }

   /**
    * Returns the value of the <code>idRawMaterialType</code> property.
    *
    */
   @Column(name = "id_raw_material_type" , nullable = false )
//  For a more generic generator, chose AUTO.
   @Id @GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
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
    * Returns the value of the <code>rawMaterialTypeName</code> property.
    *
    */
   @Column(name = "raw_material_type_name" , nullable = false , length=55 )
   public java.lang.String getRawMaterialTypeName() {
      return rawMaterialTypeName;
   }

   /**
    * Sets the value of the <code>rawMaterialTypeName</code> property.
    *
    * @param rawMaterialTypeName the value for the <code>rawMaterialTypeName</code> property
    */
   public void setRawMaterialTypeName(java.lang.String rawMaterialTypeName) {
      this.rawMaterialTypeName = rawMaterialTypeName;
   }




    /**
     * Used by the display tag library for rendering a checkbox in the list.
     * @return String with a HTML checkbox.
     */
    @Transient
    public String getCheckbox() {
        String checkBox = "<input type=\"checkbox\" name=\"checkbox";
        checkBox += "_"+ getIdRawMaterialType();
        checkBox += "\"/>";
        return checkBox;
    }


}
