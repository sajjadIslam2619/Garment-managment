package dbGarmentHibernate.entity;

import java.io.Serializable;
import com.finalist.util.log.*;

import javax.persistence.*;
import dbGarmentHibernate.*;

/**
 * The UserType entity bean.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.23 $, $Date: 2006/05/19 20:42:48 $
 *
 *
 */
@Entity
@Table(name = "user_type")
public class UserType extends DbgarmentModelBase implements Serializable {

   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(UserType.class);



   private java.lang.Integer idUserType;
   private java.lang.String userTypeName;

   /**
    * Default constructor.
    */
   public UserType() {
   }

   /**
    * Value object constructor.
    */
   public UserType(dbGarmentHibernate.entity.UserType value) {
      if (value != null) {
         setIdUserType(value.getIdUserType());
      }
      if (value != null) {
         setUserTypeName(value.getUserTypeName());
      }
   }

    /**
     * Return the primary key.
     *
     * @return java.lang.Integer with the primary key.
     */
   @javax.persistence.Transient
   public java.lang.Integer getPrimaryKey() {
        return getIdUserType();
    }

    /**
     * Set the primary key.
     *
     * @param primaryKey the primary key
     */
   @javax.persistence.Transient
   public void setPrimaryKey(java.lang.Integer primaryKey) {
       setIdUserType(primaryKey);
    }

   /**
    * Returns the value of the <code>idUserType</code> property.
    *
    */
   @Column(name = "id_user_type" , nullable = false )
//  For a more generic generator, chose AUTO.
   @Id @GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
   public java.lang.Integer getIdUserType() {
      return idUserType;
   }

   /**
    * Sets the value of the <code>idUserType</code> property.
    *
    * @param idUserType the value for the <code>idUserType</code> property
    */
   public void setIdUserType(java.lang.Integer idUserType) {
      this.idUserType = idUserType;
   }

   /**
    * Returns the value of the <code>userTypeName</code> property.
    *
    */
   @Column(name = "user_type_name" , nullable = false , length=55 )
   public java.lang.String getUserTypeName() {
      return userTypeName;
   }

   /**
    * Sets the value of the <code>userTypeName</code> property.
    *
    * @param userTypeName the value for the <code>userTypeName</code> property
    */
   public void setUserTypeName(java.lang.String userTypeName) {
      this.userTypeName = userTypeName;
   }




    /**
     * Used by the display tag library for rendering a checkbox in the list.
     * @return String with a HTML checkbox.
     */
    @Transient
    public String getCheckbox() {
        String checkBox = "<input type=\"checkbox\" name=\"checkbox";
        checkBox += "_"+ getIdUserType();
        checkBox += "\"/>";
        return checkBox;
    }


}
